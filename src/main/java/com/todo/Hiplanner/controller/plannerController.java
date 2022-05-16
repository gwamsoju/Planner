package com.todo.Hiplanner.controller;

import com.todo.Hiplanner.service.MemoService;
import com.todo.Hiplanner.vo.Memo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/planner")
@RequiredArgsConstructor
public class plannerController {

    private final MemoService memoService;

    @GetMapping("/writeFrom.do")
    public ModelAndView writeFrom(HttpSession session, ModelAndView mv,Memo memo){
        String sid = (String)session.getAttribute("id");
        mv.addObject("Data",sid);
        mv.setViewName("/planner/plannerWrite");
        return mv;
    }

}
