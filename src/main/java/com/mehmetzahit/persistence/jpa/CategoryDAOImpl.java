package com.mehmetzahit.persistence.jpa;

import com.mehmetzahit.model.Category;
import com.mehmetzahit.persistence.dao.CategoryDAO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by GUNEY on 2.12.2016.
 */
@Repository
public class CategoryDAOImpl implements CategoryDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    @Override
    public List<Category> categoryList(long parent) {
        Query query = entityManager.createQuery("FROM CATEGORY WHERE parent=:parent");
        query.setParameter("parent", parent);
        List<Category> categoryList = query.getResultList();
        return categoryList;
    }

    @Transactional
    @Override
    public List<Category> categoryList() {
        Query query = entityManager.createQuery("FROM CATEGORY");
        List<Category> categoryList = query.getResultList();
        return categoryList;
    }
}
