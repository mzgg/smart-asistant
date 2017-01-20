package com.mehmetzahit.bean;

import com.mehmetzahit.model.Member;
import com.mehmetzahit.persistence.dao.TopicDAO;
import com.mehmetzahit.persistence.jpa.TopicDAOImpl;
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
    @ManagedProperty("#{loginBean.userId}")
    private long memberId;


    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    TopicDAO topicDAO = context.getBean(TopicDAOImpl.class);

    public void saveTopic() {
        topic.setMember(new Member(memberId));
        topicDAO.saveTopic(topic);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Konu Oluşturuldu."));
        RequestContext.getCurrentInstance().execute("PF('dlg1').hide()");

    }

    public List<Topic> select() {
        return topicDAO.listTopic(memberId);
    }

}



