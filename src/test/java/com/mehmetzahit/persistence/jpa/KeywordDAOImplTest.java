package com.mehmetzahit.persistence.jpa;

import com.mehmetzahit.model.Keyword;
import com.mehmetzahit.model.Topic;
import com.mehmetzahit.persistence.dao.KeywordDAO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by GUNEY on 8.12.2016.
 */
public class KeywordDAOImplTest {
    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    KeywordDAO keywordDAO = context.getBean(KeywordDAOImpl.class);

    @Test
    public void keywordSearch() throws Exception {
        List<Keyword> keywordList= keywordDAO.keywordSearch("zahit");
        for (Keyword keyword:keywordList) {
            System.out.println(keyword.getKeyword());
        }
        Assert.assertNotNull(keywordList);
    }


    @Test
    public void insertKeyword() throws Exception {
        String[] test = {"mehmet", "zahit", "guney"};
        keywordDAO.insertKeyword(1, 1, 1, test);

    }

}