package com.mehmetzahit.bean;

import com.mehmetzahit.dao.ContentDAO;
import com.mehmetzahit.dao.ContentDAOImpl;
import com.mehmetzahit.dao.MemberDAO;
import com.mehmetzahit.dao.MemberDAOImpl;
import com.mehmetzahit.model.Content;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.context.RequestContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by GUNEY on 20.11.2016.
 */
@ManagedBean
@SessionScoped
public class TopicBean implements Serializable {

    @Setter
    @Getter
    private long topicId;

    @Getter
    @Setter
    private Content content = new Content();



    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    ContentDAO contentDAO = context.getBean(ContentDAOImpl.class);

    public void contentSave() {
        content.setTopicId(topicId);
        contentDAO.contentPersist(content);
        content = new Content(); // Jpa aynı nesneyi persist edemediği için tekrar nesne oluşturuluyor (SessionScope olduğu için)
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("İçerik Oluşturuldu."));
        RequestContext.getCurrentInstance().execute("PF('dlg2').hide()");
        // RequestContext.getCurrentInstance().reset("form:panel");


    }

    public List<Content> contents() {
        return contentDAO.contents(topicId);
    }

    public String outcome() {
        return "topic.xhtml?faces-redirect=true";
    }


}
