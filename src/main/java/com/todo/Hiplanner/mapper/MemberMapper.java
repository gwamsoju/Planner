package com.todo.Hiplanner.mapper;

import com.todo.Hiplanner.vo.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MemberMapper {

    @Select("select count(*) from member")
    public int getCnt();
    //XML 방식
    // 로그인하기
    public int getLogin(Member member);
    // 회원가입
    public void insertMember(Member member);
    // 아이디 중복 체크
    public int CheckId(Member member);
    // 회원 정보 조회
    public Member getInfo(String id);
    // 회원 정보 처리
    public void changeInfo(Member member);
    // 회원 탈퇴 처리
    public void deleteMember(Member member);
    public List<String> SearchSuggest(String id);
}


