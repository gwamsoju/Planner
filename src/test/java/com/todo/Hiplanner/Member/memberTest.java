package com.todo.Hiplanner.Member;

import com.todo.Hiplanner.mapper.MemberMapper;
import com.todo.Hiplanner.vo.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class memberTest {

    @Autowired
    private MemberMapper memberMapper;

    @Test
    public void 회원정보가져오기(){
        //given
        String id = "wodud";
        //when
        Member info = memberMapper.getInfo(id);
        //then
        assertThat(id).isEqualTo(info.getId());
    }

    @Test
    public void 회원정보변경(){
        //given
        Member member = Member.builder()
                        .id("wodud")
                        .mail("asdf@gmail.com")
                        .phone("010-4444-0000")
                        .pwd("1111")
                        .build();
        //when
        memberMapper.changeInfo(member);
        Member changeMember = memberMapper.getInfo("wodud");
        //then
        assertThat(changeMember.getMail()).isEqualTo("asdf@gmail.com");
    }

    @Test
    public void 로그인성공(){
        //given
        Member member = Member.builder()
                        .id("wodud")
                        .pwd("12345")
                        .build();
        //when
        int loginCnt = memberMapper.getLogin(member);
        //then
        assertThat(loginCnt).isEqualTo(1);
    }

    @Test
    public void 회원탈퇴(){
        //given
        Member member = Member.builder()
                .id("wodud")
                .pwd("12345")
                .build();
        //when
        memberMapper.deleteMember(member);
        int login = memberMapper.getLogin(member);
        //then
        assertThat(login).isEqualTo(0);
    }
}
