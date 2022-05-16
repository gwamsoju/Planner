package com.todo.Hiplanner.service;

import com.todo.Hiplanner.vo.Member;

import java.util.List;

public interface MemberService {

    public int getLogin(Member member);
    public List<Member> getAllMember();
    public void insertMember(Member member);
    public int CheckId(Member member);
}
