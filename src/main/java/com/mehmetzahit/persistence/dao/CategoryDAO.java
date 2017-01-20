package com.mehmetzahit.persistence.dao;

import com.mehmetzahit.model.Category;

import java.util.List;

/**
 * Created by GUNEY on 2.12.2016.
 */
public interface CategoryDAO {
    List<Category> categoryList(long parent);
    List<Category> categoryList();
}
