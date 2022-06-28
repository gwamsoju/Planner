package com.todo.Hiplanner.Member;

import com.todo.Hiplanner.mapper.MemberMapper;
import com.todo.Hiplanner.vo.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class memberTest {

    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Test
    public void 회원정보가져오기(){
        //given
        String id = "wodud";
        //when
        Member info = memberMapper.getInfo(id);
        //then
        assertThat(id).isEqualTo(info.getPassword());
    }

    @Test
    public void 회원정보변경(){
        //given
        Member member = Member.builder()
                        .username("wodud")
                        .mail("asdf@gmail.com")
                        .phone("010-4444-0000")
                        .password("1111")
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
                        .username("wodud")
                        .password("12345")
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
                .username("wodud")
                .password("12345")
                .build();
        //when
        memberMapper.deleteMember(member);
        int login = memberMapper.getLogin(member);
        //then
        assertThat(login).isEqualTo(0);
    }

    @Test
    public void 회원가입(){
        String pwd = "12345";
        String newPwd = bCryptPasswordEncoder.encode(pwd);

        Member member = Member.builder()
                .username("Test1")
                .name("이재영")
                .password(newPwd)
                .job("취준")
                .mail("wodud1207@nate.com")
                .phone("010-0000-3333")
                .gender("M")
                .build();

        memberMapper.insertMember(member);

        Member test1 = memberMapper.getInfo("Test1");

        assertThat("이재영").isEqualTo(test1.getName());
    }
}
