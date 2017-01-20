package com.mehmetzahit.persistence.jpa;

import com.mehmetzahit.persistence.dao.CategoryDAO;
import com.mehmetzahit.persistence.dao.ContentDAO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by GUNEY on 2.12.2016.
 */
public class CategoryDAOImplTest {

    @Test
    public void categoryList() throws Exception {
        ConfigurableApplicationContext context= new ClassPathXmlApplicationContext("spring-config.xml");
        CategoryDAO categoryDAO=context.getBean(CategoryDAOImpl.class);

        Assert.assertNotNull(categoryDAO.categoryList(0));
    }

}