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
    public void getCnt(){

        int cnt = memberMapper.getCnt();

        assertThat(cnt).isEqualTo(1);
    }

    //XML 방식
    @Test
    public void getCnt2(){
        int cnt = memberMapper.getCnt2(member);

        assertThat(cnt).isEqualTo(1);
    }
}
