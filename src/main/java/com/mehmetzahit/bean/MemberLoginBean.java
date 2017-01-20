package com.mehmetzahit.bean;

import com.mehmetzahit.persistence.dao.MemberDAO;
import com.mehmetzahit.persistence.jpa.MemberDAOImpl;
import com.mehmetzahit.model.Member;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 * Created by GUNEY on 20.11.2016.
 */
@ManagedBean(name = "loginBean")
@SessionScoped
public class MemberLoginBean {

    private String email;
    private String userName;
    private String password;
    private long userId;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    MemberDAO memberDAO = context.getBean(MemberDAOImpl.class);

    public void userValidate() {

        Member user = memberDAO.findUser(getUserName(), getPassword());

        System.out.println(this.userId);
        if (user == null) {
            System.out.println("hata");
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("kullanıcıadı veye Şifre Hatalı"));

        }
         else {
            this.userId = user.getMemberId();
            Authorization authorization = new Authorization();
            authorization.login();
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            setEmail(authentication.getName());

            System.out.printf(getEmail());
        }
    }
}
