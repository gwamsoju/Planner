package com.todo.Hiplanner.controller;

import com.todo.Hiplanner.config.auth.PrincipalDetails;
import com.todo.Hiplanner.service.MemberService;
import com.todo.Hiplanner.service.MemoService;
import com.todo.Hiplanner.vo.Member;
import com.todo.Hiplanner.vo.Memo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HelloController {

    private final MemoService memoService;
    private final MemberService memberService;

    @GetMapping("/")
    public String hello(){
        return "member/login";
    }
    @GetMapping("/join")
    public String joinForm(){
        return "/member/join";
    }

    @PostMapping("/login/result")
    public String loginDo(Model mv, Member member, HttpSession session, RedirectView rv, Memo memo){
        LocalDate currentDate = LocalDate.now();
        List<Memo> memoList = memoService.getMemo(memo);
        session.setAttribute("id", member.getUsername());
        mv.addAttribute("begin", currentDate);
        mv.addAttribute("memoList", memoList);
        return "main";
    }
}


