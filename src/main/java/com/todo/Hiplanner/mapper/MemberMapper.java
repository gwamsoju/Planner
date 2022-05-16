package com.todo.Hiplanner.mapper;

import com.todo.Hiplanner.vo.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberMapper {

    @Select("select count(*) from member")
    public int getCnt();
    //XML 방식
    public int getCnt2(Member member);
    public void insertMember(Member member);
    public int CheckId(Member member);
}


