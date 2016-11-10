package com.mehmetzahit.model;

import javax.persistence.*;
import java.io.Serializable;

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

    @Column(name = "MEMBER_ID")
    private long memberId;

    public Topic() {
    }

    public Topic(String topicName, String topicType, String topicDescription, long memberId) {
        this.topicName = topicName;
        this.topicType = topicType;
        this.topicDescription = topicDescription;
        this.memberId = memberId;
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

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "topicId=" + topicId +
                ", topicName='" + topicName + '\'' +
                ", topicType='" + topicType + '\'' +
                ", topicDescription='" + topicDescription + '\'' +
                ", memberId=" + memberId +
                '}';
    }
}
