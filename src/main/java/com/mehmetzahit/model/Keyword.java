package com.mehmetzahit.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by GUNEY on 21.11.2016.
 */
@Entity(name = "KEYWORD")
public class Keyword implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "KEYWORD_ID")
    private long keywordId;

    @Column(name = "KEYWORD")
    private String keyword;

    @OneToOne
    @JoinColumn(name = "TOPIC_ID")
    private Topic topic;

    @OneToOne
    @JoinColumn(name = "CONTENT_ID")
    private Content content;

    @OneToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    public Keyword() {
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

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Content getContent() {
        return content;
    }

    public void setContent(Content content) {
        this.content = content;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "Keyword{" +
                "keywordId=" + keywordId +
                ", keyword='" + keyword + '\'' +
                ", topic=" + topic +
                ", content=" + content +
                ", member=" + member +
                '}';
    }
}
