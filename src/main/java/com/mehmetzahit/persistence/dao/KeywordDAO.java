package com.mehmetzahit.persistence.dao;

import com.mehmetzahit.model.Keyword;

import java.util.List;

/**
 * Created by GUNEY on 8.12.2016.
 */
public interface KeywordDAO {

    void insertKeyword(long memeberId, long topicId, long contentId, String[] keywords);

    List<Keyword> keywordSearch(String keyword);
    List<Keyword> listToKeyword(String keyword);
    List<Keyword> listToKeyword(String keyword,String rating);

}
