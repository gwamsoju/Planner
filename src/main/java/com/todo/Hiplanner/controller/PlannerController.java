package com.todo.Hiplanner.controller;

import com.todo.Hiplanner.service.PlannerService;
import com.todo.Hiplanner.vo.Memo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/planners")
@RequiredArgsConstructor
public class PlannerController {

    private final PlannerService memoService;
    
    @GetMapping("/{begin}")
    public String planner(Memo memo, Model model){
        List<Memo> memoList = memoService.getOtherMemo(memo);
        model.addAttribute("memoList",memoList);
        model.addAttribute("begin",memo.getBegin());
        return "/planner/other";
    }

    @GetMapping("/write")
    public ModelAndView writeFrom(Authentication authentication, ModelAndView mv, Memo memo){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String sid = userDetails.getUsername();
        mv.addObject("Data",sid);
        mv.setViewName("planner/Write");
        return mv;
    }

    @PostMapping("/write")
    public String insertMemo(Memo memo, Authentication authentication, @RequestParam("begin") String begin){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        memo.setBegin(begin);
        memo.setUsername(userDetails.getUsername());
        memoService.insertMemo(memo);
        return "redirect:/planners/success";
    }

    @GetMapping("/success")
    public ModelAndView success(ModelAndView mv, Memo memo, Authentication authentication){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        memo.setUsername(userDetails.getUsername());
        List<Memo> memoList = memoService.getMemo(memo);
        mv.addObject("id",userDetails.getUsername());
        mv.addObject("memoList",memoList);
        mv.addObject("begin",memo.getBegin());
        mv.setViewName("main");
        return mv;
    }

    @GetMapping("/{planno}/Detail")
    public ModelAndView getMemoDetail(ModelAndView mv, Memo memo, Authentication authentication){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        memo.setUsername(userDetails.getUsername());
        Memo memoDetail = memoService.getMemoDetail(memo);
        mv.addObject("memoDetail",memoDetail);
        mv.setViewName("planner/Detail");
        return mv;
    }

    @GetMapping("/{planno}/delete")
    public String deleteMemo(Memo memo, Authentication authentication){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        memo.setUsername(userDetails.getUsername());
        memoService.deleteMemo(memo);
        return "redirect:/planners/success";
    }

    @PostMapping("/{planno}/edit")
    public String updateMemo(Memo memo, Authentication authentication){
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        memo.setUsername(userDetails.getUsername());
        memoService.updateMemo(memo);
        return "redirect:/planners/success";
    }

}
