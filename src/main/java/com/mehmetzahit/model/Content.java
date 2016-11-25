package com.mehmetzahit.model;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by GUNEY on 20.11.2016.
 */

@Entity(name = "CONTENT")
public class Content implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CONTENT_ID")
    private long contentId;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CONTENT")
    private String content;

    @Column(name = "TOPIC_ID")
    private long topicId;


    public Content() {
    }

    public Content(String title, String content, long topicId) {

        this.title = title;
        this.content = content;
        this.topicId = topicId;
    }

    public long getContentId() {

        return contentId;
    }

    public void setContentId(long contentId) {
        this.contentId = contentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getTopicId() {
        return topicId;
    }

    public void setTopicId(long topicId) {
        this.topicId = topicId;
    }

    @Override
    public String toString() {
        return "Content{" +
                "contentId=" + contentId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", topicId=" + topicId +
                '}';
    }
}
