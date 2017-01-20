package com.mehmetzahit.persistence.jpa;

import com.mehmetzahit.persistence.dao.TopicDAO;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by GUNEY on 11.01.2017.
 */
public class TopicDAOImplTest {
    @Test
    public void listTopic() throws Exception {

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        TopicDAO topicDAO = context.getBean(TopicDAOImpl.class);

        assertNotNull(topicDAO.listTopic(1));

    }

}