package com.todo.Hiplanner.controller;

import com.todo.Hiplanner.service.MemberService;
import com.todo.Hiplanner.vo.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;


    @PostMapping("/login")
    public ModelAndView loginDo(ModelAndView mv, Member member, HttpSession session, RedirectView rv){
        int count = memberService.getLogin(member);
        LocalDate currentDate = LocalDate.now();

        if(count == 1){
            session.setAttribute("id", member.getId());
            mv.addObject("begin",currentDate);
            mv.setViewName("main");
        }else{
            rv.setUrl("/");
            mv.setView(rv);
        }
        return mv;
    }

    @GetMapping("/logout")
    public String logoutDo(HttpSession session){
        session.removeAttribute("id");
        return "member/login";
    }
    @GetMapping("/join")
    public String joinForm(){
        return "/member/join";
    }

    @PostMapping("/join")
    public String joinProc(Member member, RedirectView rv,String id){
        int result = memberService.CheckId(member);

        if(result == 1){
            return "/member/join";
        }else{
            memberService.insertMember(member);
            return "redirect:/";
        }
    }

    @ResponseBody
    @RequestMapping("/id/check")
    public int idCheck(Member member){
        return memberService.CheckId(member);
    }

    @GetMapping("/{id}")
    public ModelAndView getInfo(ModelAndView mv, HttpSession session){
        String id = (String)session.getAttribute("id");
        Member memberinfo = memberService.getInfo(id);

        mv.addObject("member",memberinfo);
        mv.setViewName("member/info");
        return mv;
    }

    @PostMapping("/{id}/update")
    public String changeInfo(Member member){
        memberService.changeInfo(member);
        return "member/login";
    }

    @GetMapping("/delete")
    public String deleteForm(){
        return "member/delete";
    }

    @PostMapping("/{id}/delete")
    public String deleteMember(Member member, HttpSession session){
        member.setId((String)session.getAttribute("id"));
        memberService.deleteMember(member);

        return "member/login";
    }

}
