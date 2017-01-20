package com.mehmetzahit.bean;

import com.mehmetzahit.model.Content;
import com.mehmetzahit.model.Keyword;
import com.mehmetzahit.persistence.dao.ContentDAO;
import com.mehmetzahit.persistence.dao.KeywordDAO;
import com.mehmetzahit.persistence.jpa.ContentDAOImpl;
import com.mehmetzahit.persistence.jpa.KeywordDAOImpl;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by GUNEY on 13.01.2017.
 */
@ManagedBean
@SessionScoped
public class SearchBean {

    private int restriction;
    private String keyword;
    private String rating;

    ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
    KeywordDAO keywordDAO = context.getBean(KeywordDAOImpl.class);
    ContentDAO contentDAO = context.getBean(ContentDAOImpl.class);

    public List<String> completeText(String query) {
        List<String> results = new ArrayList<String>();
        System.out.println(query);
        List<Keyword> keywordList = keywordDAO.keywordSearch(query);
        System.out.println(keywordList);
        for (Keyword keyword : keywordList) {
            results.add(keyword.getKeyword());
        }
        return results;
    }

    public <T> T searchResultList() throws IOException {
        if (restriction == 1) {
            if (rating.isEmpty()) {
                List<Keyword> keywordList = keywordDAO.listToKeyword(keyword);
                System.out.println("bura null" + keywordList.toString());
                //FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("searchBean");
                return (T) keywordList;

            } else {
                System.out.println("rating deger" + rating);
                List<Keyword> keywordList = keywordDAO.listToKeyword(keyword, rating);
                System.out.println("bura null değil" + keywordList.toString());

                return (T) keywordList;

            }
        } else {
            if (rating.isEmpty()) {
                List<Content> contentList = contentDAO.listToContent(keyword);
                return (T) contentList;
            } else {
                List<Content> contentList = contentDAO.listToContent(keyword, rating);
                return (T) contentList;
            }
        }
    }


    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getRestriction() {
        return restriction;
    }

    public void setRestriction(int restriction) {
        this.restriction = restriction;
        System.out.println(restriction);
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
