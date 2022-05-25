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
        String id = "wodud";
        Member info = memberMapper.getInfo(id);

        assertThat(id).isEqualTo(info.getId());
    }

    @Test
    public void 회원정보변경(){
        String id = "wodud";
        String mail = "asdf@gmail.com";
        String phone = "010-4444-0000";
        String pwd = "1111";

        Member member = new Member();
        member.setId(id);
        member.setMail(mail);
        member.setPhone(phone);
        member.setPwd(pwd);

        memberMapper.changeInfo(member);

        Member changeMember = memberMapper.getInfo(id);
        assertThat(changeMember.getMail()).isEqualTo(mail);
    }

    @Test
    public void 로그인성공(){
        Member member = new Member();
        member.setId("wodud");
        member.setPwd("12345");

        int loginCnt = memberMapper.getLogin(member);
        assertThat(loginCnt).isEqualTo(1);
    }

    @Test
    public void 회원탈퇴(){
        Member member = new Member();
        member.setId("wodud");
        member.setPwd("12345");

        memberMapper.deleteMember(member);

        int login = memberMapper.getLogin(member);

        assertThat(login).isEqualTo(0);
    }
}
