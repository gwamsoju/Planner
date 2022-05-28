package com.todo.Hiplanner.DependencyTest;

import com.todo.Hiplanner.HiplannerApplication;
import com.todo.Hiplanner.service.MemberService;
import com.todo.Hiplanner.service.MemberServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class DependencyTest1 {



    @Test
    public void 의존주입테스트(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(HiplannerApplication.class);
        MemberServiceImpl memberService = ac.getBean(MemberServiceImpl.class);

        assertThat(memberService).isInstanceOf(MemberService.class);

    }
}
