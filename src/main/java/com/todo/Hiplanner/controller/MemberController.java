package com.todo.Hiplanner.controller;

import com.todo.Hiplanner.service.MemberService;
import com.todo.Hiplanner.service.PlannerService;
import com.todo.Hiplanner.vo.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final PlannerService memoService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/{username}")
    public ModelAndView getInfo(ModelAndView mv, HttpSession session){
        String id = (String)session.getAttribute("id");
        Member memberinfo = memberService.getInfo(id);

        mv.addObject("member",memberinfo);
        mv.setViewName("member/info");
        return mv;
    }

    @PostMapping("/{username}/update")
    public String changeInfo(Member member){
        String passwordRaw = member.getPassword();
        String encode = bCryptPasswordEncoder.encode(passwordRaw);
        member.setPassword(encode);
        memberService.changeInfo(member);
        return "member/login";
    }

    @GetMapping("/delete")
    public String deleteForm(){
        return "member/delete";
    }

    @PostMapping("/{id}/delete")
    public String deleteMember(Member member, HttpSession session){
        member.setUsername((String)session.getAttribute("id"));
        memberService.deleteMember(member);

        return "member/login";
    }

}
