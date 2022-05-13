package com.todo.Hiplanner.controller;

import com.todo.Hiplanner.service.MemberService;
import com.todo.Hiplanner.vo.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/loginProc.do")
    public ModelAndView loginDo(ModelAndView mv, Member member, HttpSession session, RedirectView rv){
        int count = memberService.getLogin(member);
        if(count == 1){
            session.setAttribute("id", member.getId());
            System.out.println("member.getId() = " + member.getId());
            mv.addObject("Data",member.getId());
            mv.setViewName("main");
        }else{
            rv.setUrl("/");
            mv.setView(rv);
        }
        return mv;
    }

    @GetMapping("/logoutProc.do")
    public ModelAndView logoutDo(ModelAndView mv, RedirectView rv, HttpSession session){
        session.removeAttribute("id");

        rv.setUrl("/");
        mv.setView(rv);
        return mv;
    }

    @GetMapping("/join.do")
    public String joinForm(){
        return "/member/join";
    }


}
