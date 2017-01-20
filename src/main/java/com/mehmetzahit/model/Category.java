package com.mehmetzahit.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by GUNEY on 2.12.2016.
 */
@Entity(name = "CATEGORY")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID")
    private long CategoryId;

    @Column(name = "CATEGORY_NAME")
    private String Categoryname;

    @Column(name = "PARENT")
    private long parent;

    public long getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(long categoryId) {
        CategoryId = categoryId;
    }

    public String getCategoryname() {
        return Categoryname;
    }

    public void setCategoryname(String categoryname) {
        Categoryname = categoryname;
    }

    public long getParent() {
        return parent;
    }

    public void setParent(long parent) {
        this.parent = parent;
    }
}
