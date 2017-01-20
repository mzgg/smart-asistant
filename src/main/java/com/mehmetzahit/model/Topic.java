package com.mehmetzahit.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by GUNEY on 9.11.2016.
 */
@Entity(name = "TOPIC")
public class Topic implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TOPIC_ID")
    private long topicId;

    @Column(name = "TOPIC_NAME")
    private String topicName;

    @Column(name = "TOPIC_TYPE")
    private String topicType;

    @Column(name = "DESCRIPTIN")
    private String topicDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_MEMBER_ID")
    private Member member;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "topic",cascade = CascadeType.ALL)
    private List<Content> contentList;

    public Topic() {
    }

    public Topic(long topicId) {
        this.topicId = topicId;
    }

    public long getTopicId() {
        return topicId;
    }

    public void setTopicId(long topicId) {
        this.topicId = topicId;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicType() {
        return topicType;
    }

    public void setTopicType(String topicType) {
        this.topicType = topicType;
    }

    public String getTopicDescription() {
        return topicDescription;
    }

    public void setTopicDescription(String topicDescription) {
        this.topicDescription = topicDescription;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public List<Content> getContentList() {
        return contentList;
    }

    public void setContentList(List<Content> contentList) {
        this.contentList = contentList;
    }


}