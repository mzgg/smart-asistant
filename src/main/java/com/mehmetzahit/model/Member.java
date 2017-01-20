package com.mehmetzahit.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by GUNEY on 8.11.2016.
 */
@Entity(name = "MEMBER")
public class Member implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEMBER_ID")
    private long memberId;

    @Column(name = "MEMBER_NAME")
    private String memberName;

    @Column(name = "MEMBER_SURNAME")
    private String memberSurname;

    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "ENABLED")
    private int enabled;

    @Column(name = "ROLE")
    private int role;

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "member",cascade = CascadeType.ALL)
    private List<Topic> topicList;


    public Member() {
    }

    public Member(long memberId) {
        this.memberId = memberId;
    }

    public Member(String memberName, String memberSurname, String emailAddress, String password, int enabled, int role) {

        this.memberName = memberName;
        this.memberSurname = memberSurname;
        this.emailAddress = emailAddress;
        this.password = password;
        this.enabled = enabled;
        this.role = role;
    }

    public long getMemberId() {

        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberSurname() {
        return memberSurname;
    }

    public void setMemberSurname(String memberSurname) {
        this.memberSurname = memberSurname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public List<Topic> getTopicList() {
        return topicList;
    }

    public void setTopicList(List<Topic> topicList) {
        this.topicList = topicList;
    }


    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", memberName='" + memberName + '\'' +
                ", memberSurname='" + memberSurname + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", role=" + role +
                '}';
    }
}
