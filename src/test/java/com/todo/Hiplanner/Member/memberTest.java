package com.todo.Hiplanner.Member;

import com.todo.Hiplanner.HiplannerApplication;
import com.todo.Hiplanner.mapper.MemberMapper;
import com.todo.Hiplanner.repository.MemberRepository;
import com.todo.Hiplanner.repository.MemberRepositoryImpl;
import com.todo.Hiplanner.vo.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.annotation.Annotation;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class memberTest {

    @Test
    public void insertTest(){
        Member member = new Member("leepond","이지연","1234","회사원","leepond@naver.com","010-0000-1111","M");
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(HiplannerApplication.class);
        MemberMapper memberMapper = ac.getBean(MemberMapper.class);
        memberMapper.insertMember(member);
        int cnt = memberMapper.getCnt2(member);

        assertThat(cnt).isEqualTo(1);
    }
}
