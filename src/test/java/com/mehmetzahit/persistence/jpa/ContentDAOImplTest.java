package com.mehmetzahit.persistence.jpa;

import com.mehmetzahit.model.Content;
import com.mehmetzahit.model.Topic;
import com.mehmetzahit.persistence.dao.ContentDAO;
import com.mehmetzahit.persistence.jpa.ContentDAOImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by GUNEY on 20.11.2016.
 */
public class ContentDAOImplTest {


    ConfigurableApplicationContext context;
    ContentDAO contentDAO;

    @Before
    public void setUp() throws Exception {

        context = new ClassPathXmlApplicationContext("spring-config.xml");
        contentDAO = context.getBean(ContentDAOImpl.class);
    }

    @Test
    public void listToContent() throws Exception {
        List<Content> contents = contentDAO.listToContent("oncelikle", "3");
        System.out.println(contents);
        Assert.assertNotNull(contents);

    }

    @Test
    public void contentPersist1() throws Exception {
        Content content = new Content();
        content.setTitle("Test Data");
        content.setContent("Test Data");
        contentDAO.contentPersist(content);
    }

    @Test
    public void contentPersist() throws Exception {
        Content content = new Content();
        content.setTitle("türkçee");
        content.setContent("Initial testing data");
        content.setTopic(new Topic(1));
        contentDAO.contentPersist(content);


    }

    @Test
    public void contents() throws Exception {

        try {
            Assert.assertNotNull(contentDAO.contents(1, 1));
        } catch (Exception e) {
            throw new RuntimeException();
        }

    }


}