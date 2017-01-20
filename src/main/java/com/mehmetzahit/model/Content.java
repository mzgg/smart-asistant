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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONTENT_ID")
    private long contentId;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "CONTENT",columnDefinition = "TEXT")
    private String content;

    @Column(name = "RATING")
    private String rating;


    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "FK_TOPIC_ID")
    private Topic topic;


    public Content() {
    }

    public Content(long contentId) {
        this.contentId = contentId;
    }

    public Content(String title, String content) {

        this.title = title;
        this.content = content;
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

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    @Override
    public String toString() {
        return "Content{" +
                "contentId=" + contentId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", rating='" + rating + '\'' +
                ", topic=" + topic +
                '}';
    }
}
