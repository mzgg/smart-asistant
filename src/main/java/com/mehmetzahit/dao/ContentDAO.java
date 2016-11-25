package com.mehmetzahit.dao;

import com.mehmetzahit.model.Content;

import java.util.List;

/**
 * Created by GUNEY on 20.11.2016.
 */
public interface ContentDAO {
    void contentPersist(Content content);
    List<Content> contents(long topicId);
}
