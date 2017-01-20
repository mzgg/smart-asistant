package com.mehmetzahit.persistence.jpa;

import com.mehmetzahit.model.Content;
import com.mehmetzahit.persistence.dao.ContentDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
    public long contentPersist(Content content) {
        entityManager.persist(content);
        entityManager.flush();//mevut nesneden tekrar id numarasını alıp kullanabilmek için
        return content.getContentId();
    }

    @Override
    @Transactional
    public List<Content> contents(long memberId, long topicId) {
        Query query = entityManager.createQuery("SELECT c FROM CONTENT c WHERE c.topic.topicId=:topicId and c.topic.member.memberId=:memberId");
        query.setParameter("topicId", topicId);
        query.setParameter("memberId", memberId);
        List<Content> contents = query.getResultList();
        return contents;
    }

    @Override
    @Transactional
    public List<Content> listToContent(String content) {
        Query query = entityManager.createQuery("SELECT DISTINCT c FROM CONTENT c WHERE c.content LIKE :content or c.title LIKE :content");
        query.setParameter("content", '%' + content + '%');
        return query.getResultList();
    }

    @Override
    @Transactional
    public List<Content> listToContent(String content, String rating) {
        Query query = entityManager.createQuery("SELECT c FROM CONTENT c WHERE (c.content LIKE :content OR c.title LIKE :content) and c.rating=:rating");
        query.setParameter("content", content + '%');
        query.setParameter("rating", rating);
        return query.getResultList();
    }
}
