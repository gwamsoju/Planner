package com.todo.Hiplanner.repository;

import com.todo.Hiplanner.mapper.MemberMapper;
import com.todo.Hiplanner.vo.Member;
import lombok.RequiredArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepository{

    private final SqlSessionTemplate sqlSession;

    private static final String Namespace = "com.todo.Hiplannder.mapper.MemberMapper";

    @Override
    public int getLogin(Member member) {
        return sqlSession.selectOne(Namespace + ".getCnt2", member);
    }
}
