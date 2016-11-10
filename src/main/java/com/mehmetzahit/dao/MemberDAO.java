package com.mehmetzahit.dao;

import com.mehmetzahit.model.Member;

import java.util.List;

/**
 * Created by GUNEY on 1.11.2016.
 */

public interface MemberDAO {
    void insertMember(Member member);
    Member findUser(String userName);
}
