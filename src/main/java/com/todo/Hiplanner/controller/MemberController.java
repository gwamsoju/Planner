package com.todo.Hiplanner.controller;

import com.todo.Hiplanner.config.auth.PrincipalDetails;
import com.todo.Hiplanner.service.MemberService;
import com.todo.Hiplanner.vo.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/{username}")
    public ModelAndView getInfo( ModelAndView mv, Authentication authentication){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String id = userDetails.getUsername();
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
    public String deleteForm(Authentication authentication, Model model){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        model.addAttribute("username",username);
        return "member/delete";
    }

    @PostMapping("/{username}/delete")
    public String deleteMember(Member member, Authentication authentication){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        member.setUsername(userDetails.getUsername());
        memberService.deleteMember(member);

        return "member/login";
    }

}
