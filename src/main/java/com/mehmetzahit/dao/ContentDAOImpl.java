package com.mehmetzahit.dao;

import com.mehmetzahit.model.Content;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by GUNEY on 20.11.2016.
 */
@Repository
public class ContentDAOImpl implements ContentDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void contentPersist(Content content) {
        entityManager.persist(content);
    }

    @Override
    @Transactional
    public List<Content> contents(long topicId) {
        Query query = entityManager.createQuery("FROM CONTENT C WHERE C.topicId=:topicId", Content.class);
        query.setParameter("topicId", topicId);
        List<Content> contents = query.getResultList();
        return contents;
    }
}
