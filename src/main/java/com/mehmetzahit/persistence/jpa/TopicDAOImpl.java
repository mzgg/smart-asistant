package com.mehmetzahit.persistence.jpa;

import com.mehmetzahit.model.Topic;
import com.mehmetzahit.persistence.dao.TopicDAO;
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
    public List<Topic> listTopic(long memberId) {
        Query query = entityManager.createQuery("SELECT t FROM TOPIC t WHERE t.member.memberId=:topic");
        query.setParameter("topic",memberId);
        List<Topic> topics = query.getResultList();

        return topics;
    }
}
