package com.mehmetzahit.bean;

import com.mehmetzahit.model.Keyword;
import com.mehmetzahit.model.Topic;
import com.mehmetzahit.persistence.dao.ContentDAO;
import com.mehmetzahit.persistence.dao.KeywordDAO;
import com.mehmetzahit.persistence.jpa.ContentDAOImpl;
import com.mehmetzahit.model.Content;
import com.mehmetzahit.persistence.jpa.KeywordDAOImpl;
import lombok.Getter;
import lombok.Setter;
import org.primefaces.context.RequestContext;
import org.primefaces.event.RateEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Getter
    @Setter
    private String rating;

    @Getter
    @Setter
    private String keyword;

    @Setter
    @Getter
    @ManagedProperty("#{loginBean.userId}")
    private long memberId;

    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    ContentDAO contentDAO = context.getBean(ContentDAOImpl.class);
    KeywordDAO keywordDAO = context.getBean(KeywordDAOImpl.class);

    public void contentSave() throws IOException {
        content.setTopic(new Topic(topicId));
        content.setRating(rating);
        long contentId = contentDAO.contentPersist(content);
        keywordDAO.insertKeyword(memberId,topicId,contentId, parseString(keyword));
        content = new Content(); // Jpa aynı nesneyi persist edemediği için tekrar nesne oluşturuluyor (SessionScope olduğu için)
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("İçerik Oluşturuldu."));
        RequestContext.getCurrentInstance().execute("PF('dlg2').hide()");
        context.getExternalContext().redirect("topic.xhtml?faces-redirect=true");
        System.out.println(rating);

    }

    public static String[] parseString(String key) {
        List list = new ArrayList();

        String keyword[] = null;
        keyword = key.split(",");
        System.out.println(Arrays.toString(keyword));
        return keyword;
    }




    public List<Content> contents() {
        return contentDAO.contents(memberId, topicId);
    }

    public String outcome() {
        return "topic.xhtml?faces-redirect=true";
    }


}
