package com.mehmetzahit.bean;

import com.mehmetzahit.dao.MemberDAO;
import com.mehmetzahit.dao.MemberDAOImpl;
import com.mehmetzahit.dao.TopicDAO;
import com.mehmetzahit.dao.TopicDAOImpl;
import com.mehmetzahit.model.Topic;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.context.RequestContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by GUNEY on 9.11.2016.
 */
@ManagedBean
@RequestScoped
public class TopicCreateBean implements Serializable {

    @Setter
    @Getter
    private Topic topic = new Topic();

    @Setter
    @Getter
    private long memberId; //ActionPropertyListener

    @ManagedProperty("#{test}")
    private  UserBean userBean;

    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    TopicDAO topicDAO = context.getBean(TopicDAOImpl.class);

    public void saveTopic(Topic topic) {
        topic.setMemberId(memberId);
       // System.out.println(memberId);
        topicDAO.saveTopic(topic);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Konu Oluşturuldu."));
        RequestContext.getCurrentInstance().execute("PF('dlg1').hide()");

    }

    public List<Topic> select() {
        System.out.println(userBean.getMember().getMemberId());
        return topicDAO.listTopic(memberId);
    }

}



