package com.mehmetzahit.bean;

import com.mehmetzahit.model.Member;
import com.mehmetzahit.dao.MemberDAO;
import com.mehmetzahit.dao.MemberDAOImpl;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 * Created by GUNEY on 8.11.2016.
 */
@ManagedBean
@RequestScoped
public class MemberRegistrationBean implements Serializable {

    @Getter
    @Setter
    private Member member = new Member();

    @Getter
    @Setter
    private boolean visibility = true;


    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    MemberDAO memberDAO = context.getBean(MemberDAOImpl.class);


    public void save(Member member) throws IOException {
        member.setRole(1);
        member.setEnabled(1);
        memberDAO.insertMember(member);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful", "Kayıt Başarılı"));
        context.getExternalContext().redirect("index.xhtml");
        visibility = false;

    }


}
