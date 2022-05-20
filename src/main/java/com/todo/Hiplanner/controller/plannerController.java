package com.todo.Hiplanner.controller;

import com.todo.Hiplanner.service.MemoService;
import com.todo.Hiplanner.vo.Memo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/planner")
@RequiredArgsConstructor
public class plannerController {

    private final MemoService memoService;

    @GetMapping("/")
    public ModelAndView planner(Memo memo, ModelAndView mv, HttpSession session){

        memo.setId((String)session.getAttribute("id"));
        List<Memo> memoList = memoService.getMemo(memo);
        mv.addObject("memoList",memoList);
        mv.setViewName("/planner/planner");
        return mv;
    }

    @GetMapping("/writeFrom.do")
    public ModelAndView writeFrom(HttpSession session, ModelAndView mv,Memo memo){
        String sid = (String)session.getAttribute("id");
        mv.addObject("Data",sid);
        mv.setViewName("/planner/plannerWrite");
        return mv;
    }

    @PostMapping("/writeFinish.do")
    public String insertMemo( Memo memo, RedirectView rv, HttpSession session){

        memo.setId((String)session.getAttribute("id"));
        memoService.insertMemo(memo);

        return "redirect:/planner/Writesuccess";
    }

    @GetMapping("/Writesuccess")
    public ModelAndView success(ModelAndView mv, Memo memo, HttpSession session){
        memo.setId((String)session.getAttribute("id"));
        List<Memo> memoList = memoService.getMemo(memo);
        mv.addObject("memoList",memoList);
        mv.setViewName("main");
        return mv;
    }

    @GetMapping("/Detail.do")
    public ModelAndView getMemoDetail(ModelAndView mv, Memo memo, HttpSession session){
        memo.setId((String)session.getAttribute("id"));
        Memo memoDetail = memoService.getMemoDetail(memo);

        mv.addObject("memoDetail",memoDetail);
        mv.setViewName("/planner/plannerDetail");
        return mv;
    }

}
