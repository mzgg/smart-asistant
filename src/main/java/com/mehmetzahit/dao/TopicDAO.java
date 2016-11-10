package com.mehmetzahit.dao;

import com.mehmetzahit.model.Topic;

import java.util.List;

/**
 * Created by GUNEY on 9.11.2016.
 */
public interface TopicDAO {
    void saveTopic(Topic topic);
    List<Topic> listTopic(long topicId);
}
