package com.mehmetzahit.persistence.dao;

import com.mehmetzahit.model.Content;
import com.mehmetzahit.model.Keyword;

import java.util.List;

/**
 * Created by GUNEY on 20.11.2016.
 */
public interface ContentDAO {
    long contentPersist(Content content);

    List<Content> contents(long memberId, long topicId);
    List<Content> listToContent(String content);
    List<Content> listToContent(String content,String rating);
}
