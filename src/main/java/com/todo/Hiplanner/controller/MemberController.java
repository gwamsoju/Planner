package com.todo.Hiplanner.controller;

import com.todo.Hiplanner.service.MemberService;
import com.todo.Hiplanner.service.MemoService;
import com.todo.Hiplanner.vo.Member;
import com.todo.Hiplanner.vo.Memo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final MemoService memoService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/logout")
    public String logoutDo(HttpSession session){
        session.removeAttribute("id");
        return "member/login";
    }

    @PostMapping("/join")
    public String joinProc(Member member){

        member.setRole("ROLE_USER");
        String passwordRaw = member.getPassword();
        String encode = bCryptPasswordEncoder.encode(passwordRaw);
        member.setPassword(encode);
        memberService.insertMember(member);
        return "redirect:/";
    }

    @ResponseBody
    @PostMapping("/id/check")
    public int idCheck(Member member){
        return memberService.CheckId(member);
    }

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
