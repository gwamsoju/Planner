package com.todo.Hiplanner.controller;

import com.todo.Hiplanner.service.MailService;
import com.todo.Hiplanner.service.MemberService;
import com.todo.Hiplanner.service.PlannerService;
import com.todo.Hiplanner.vo.Member;
import com.todo.Hiplanner.vo.Memo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final MemberService memberService;
    private final PlannerService memoService;
    private final MailService mailService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/join")
    public String joinForm(){
        return "/member/join";
    }

    @GetMapping("/login/result")
    public String loginDo(Model mv, Memo memo, Authentication authentication){
        LocalDate currentDate = LocalDate.now();
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        memo.setUsername(userDetails.getUsername());
        List<Memo> memoList = memoService.getMemo(memo);
        mv.addAttribute("id",userDetails.getUsername());
        mv.addAttribute("begin", currentDate);
        mv.addAttribute("memoList", memoList);
        return "main";
    }

    @GetMapping("/logoutProc")
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

    @ResponseBody
    @PostMapping("/mailConfirm")
    public String mailConfirm(String mail) throws Exception {
        System.out.println("인증 이메일 : " + mail);
        // 인증 번호를 해당 이메일로 전송
        int number = mailService.sendEmail(mail);
        // 그리고 인증 번호를 해당 DB에 저장

        // 유저가 입력한 번호와 DB의 값을 비교

        // 번호가 맞다면 DB에 인증을 완료했다는 것을 넣어야 하는데 ..... <input> 태그에 저장해두고 회원 가입 버튼 누르면 같이 전송되도록 ?
        return "인증 번호 보내기 성공!";
    }

}
