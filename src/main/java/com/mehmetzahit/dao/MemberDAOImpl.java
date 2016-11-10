package com.mehmetzahit.dao;

import com.mehmetzahit.model.Member;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by GUNEY on 1.11.2016.
 */
@Repository
public class MemberDAOImpl implements MemberDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void insertMember(Member member) {
        entityManager.persist(member);
    }

    @Override
    public Member findUser(String userName) {
        Query query = entityManager.createQuery("FROM MEMBER m WHERE m.emailAddress=:user",Member.class);
        query.setParameter("user", userName);

        Member member = (Member) query.getSingleResult();
        return member;
    }


    public EntityManager getEntityManager() {
        return entityManager;
    }


    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
