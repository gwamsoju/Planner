package com.todo.Hiplanner.MybatisTest;

import com.todo.Hiplanner.mapper.MemberMapper;
import com.todo.Hiplanner.vo.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class Test1 {

    @Autowired
    private MemberMapper memberMapper;

    Member member = new Member();

    @Test
    public void 마이바티스연동테스트1(){

        int cnt = memberMapper.getCnt();

        assertThat(cnt).isEqualTo(1);
    }

    //XML 방식
    @Test
    public void 마이바티스연동테스트2(){
        int cnt = memberMapper.getLogin(member);

        assertThat(cnt).isEqualTo(1);
    }
}
