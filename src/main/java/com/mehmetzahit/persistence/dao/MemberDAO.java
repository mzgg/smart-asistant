package com.mehmetzahit.persistence.dao;

import com.mehmetzahit.model.Member;

/**
 * Created by GUNEY on 1.11.2016.
 */

public interface MemberDAO {
    void insertMember(Member member);
    Member findUser(String userName);
    Member findUser(String email, String password);
}
