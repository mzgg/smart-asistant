package com.mehmetzahit.dao;

import com.mehmetzahit.model.Topic;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by GUNEY on 9.11.2016.
 */
@Repository
public class TopicDAOImpl implements TopicDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void saveTopic(Topic topic) {
        entityManager.persist(topic);

    }

    @Override
    @Transactional
    public List<Topic> listTopic(long topicId) {
        Query query = entityManager.createQuery("FROM TOPIC t WHERE t.memberId=:topic",Topic.class);
        query.setParameter("topic",topicId);
        List<Topic> topics = query.getResultList();

        return topics;
    }
}
