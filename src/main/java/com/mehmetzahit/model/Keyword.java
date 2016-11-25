package com.mehmetzahit.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by GUNEY on 21.11.2016.
 */
@Entity
public class Keyword implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "KEYWORD_ID")
    private long keywordId;

    @Column(name = "KEYWORD")
    private String keyword;

    @Column(name = "TOPIC_ID")
    private long topicId;

    @Column(name = "CONTENT_ID")
    private long contentId;

    @Column(name = "MEMBER_ID")
    private long memberId;

    public Keyword() {
    }

    public Keyword(String keyword, long topicId, long contentId, long memberId) {

        this.keyword = keyword;
        this.topicId = topicId;
        this.contentId = contentId;
        this.memberId = memberId;
    }

    public long getKeywordId() {

        return keywordId;
    }

    public void setKeywordId(long keywordId) {
        this.keywordId = keywordId;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public long getTopicId() {
        return topicId;
    }

    public void setTopicId(long topicId) {
        this.topicId = topicId;
    }

    public long getContentId() {
        return contentId;
    }

    public void setContentId(long contentId) {
        this.contentId = contentId;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "Keyword{" +
                "keywordId=" + keywordId +
                ", keyword='" + keyword + '\'' +
                ", topicId=" + topicId +
                ", contentId=" + contentId +
                ", memberId=" + memberId +
                '}';
    }
}
