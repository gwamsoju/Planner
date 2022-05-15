package com.todo.Hiplanner.service;

import com.todo.Hiplanner.mapper.MemberMapper;
import com.todo.Hiplanner.vo.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberMapper memberMapper;

    @Override
    public int getLogin(Member member) {
        return memberMapper.getCnt2(member);
    }

    @Override
    public List<Member> getAllMember() {
        return null;
    }

    @Override
    public void insertMember(Member member) {
        memberMapper.insertMember(member);
    }
}
