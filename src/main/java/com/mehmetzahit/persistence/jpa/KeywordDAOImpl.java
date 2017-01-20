package com.mehmetzahit.persistence.jpa;

import com.mehmetzahit.model.Content;
import com.mehmetzahit.model.Keyword;
import com.mehmetzahit.model.Member;
import com.mehmetzahit.model.Topic;
import com.mehmetzahit.persistence.dao.KeywordDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by GUNEY on 8.12.2016.
 */
@Repository
public class KeywordDAOImpl implements KeywordDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public void insertKeyword(long memberId, long topicId, long contentId, String[] keywords) {
        for (String keyword : keywords) {
            Keyword keyword1 = new Keyword();
            keyword1.setTopic(new Topic(topicId));
            keyword1.setMember(new Member(memberId));
            keyword1.setTopic(new Topic(topicId));
            keyword1.setContent(new Content(contentId));
            keyword1.setKeyword(keyword);
            System.out.println(keyword1);
            entityManager.persist(keyword1);
        }
    }

    @Override
    @Transactional
    public List<Keyword> keywordSearch(String keyword) {
        Query query = entityManager.createQuery("SELECT DISTINCT k FROM KEYWORD k WHERE k.keyword LIKE :keyword");
        query.setParameter("keyword",keyword + '%');

        return query.getResultList();
    }

    @Override
    @Transactional
    public List<Keyword> listToKeyword(String keyword, String rating) {
        Query query = entityManager.createQuery("SELECT DISTINCT k FROM KEYWORD k WHERE k.keyword=:keyword and k.content.rating=:rating");
        query.setParameter("keyword",keyword);
        query.setParameter("rating",rating);
        return query.getResultList();
    }

    @Override
    @Transactional
    public List<Keyword> listToKeyword(String keyword) {
        Query query = entityManager.createQuery("SELECT DISTINCT k FROM KEYWORD k WHERE k.keyword=:keyword");
        query.setParameter("keyword",keyword);
        return query.getResultList();
    }
}
