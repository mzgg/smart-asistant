package com.mehmetzahit.persistence.jpa;

import com.mehmetzahit.model.Member;
import com.mehmetzahit.persistence.dao.MemberDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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

    @Override
    @Transactional
    public Member findUser(String email, String password) {
        try {
            TypedQuery<Member> query = entityManager.createQuery("SELECT M FROM MEMBER M WHERE M.emailAddress=:emailQuery  AND M.password=:passwordQuery", Member.class);
            query.setParameter("emailQuery", email);
            query.setParameter("passwordQuery", password);

            return query.getSingleResult();

        } catch (Exception e) {
            return null;

        }

    }

    public EntityManager getEntityManager() {
        return entityManager;
    }


    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
