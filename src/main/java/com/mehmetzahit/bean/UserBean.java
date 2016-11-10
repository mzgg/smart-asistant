package com.mehmetzahit.bean;

import com.mehmetzahit.dao.MemberDAO;
import com.mehmetzahit.dao.MemberDAOImpl;
import com.mehmetzahit.model.Member;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 * Created by GUNEY on 9.11.2016.
 */
@ManagedBean
@SessionScoped
public class UserBean {
    private String userName;
    private Member member;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }


    public void userFind() {
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        MemberDAO memberDAO = context.getBean(MemberDAOImpl.class);

        System.out.println(getUserName());
        Member user = memberDAO.findUser(userName);
        setMember(user);
        //  System.out.println(user.toString());
    }


}
