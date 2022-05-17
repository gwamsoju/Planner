package com.todo.Hiplanner.controller;

import com.todo.Hiplanner.service.MemberService;
import com.todo.Hiplanner.service.MemoService;
import com.todo.Hiplanner.vo.Member;
import com.todo.Hiplanner.vo.Memo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final MemoService memoService;


    @PostMapping("/loginProc.do")
    public ModelAndView loginDo(ModelAndView mv, Member member, HttpSession session, RedirectView rv, Memo memo){
        int count = memberService.getLogin(member);
        List<Memo> memoList= memoService.getMemo(memo);
        if(count == 1){
            session.setAttribute("id", member.getId());
            System.out.println("member.getId() = " + member.getId());
            mv.addObject("memoList",memoList);
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

    @PostMapping("/joinProc.do")
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
    @RequestMapping("/IdCheck")
    public int idCheck(Member member){
        return memberService.CheckId(member);
    }

    @GetMapping("/getInfo.do")
    public ModelAndView getInfo(ModelAndView mv, HttpSession session,String id){

        Member memberinfo = memberService.getInfo(id);

        mv.addObject("member",memberinfo);
        mv.setViewName("/member/memberInfo");
        return mv;
    }

    @PostMapping("/edit.do")
    public String changeInfo(Member member){
        memberService.changeInfo(member);
        return "member/login";
    }

}
