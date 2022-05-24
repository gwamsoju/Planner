package com.todo.Hiplanner.controller;

import com.todo.Hiplanner.service.MemoService;
import com.todo.Hiplanner.vo.Memo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/planners")
@RequiredArgsConstructor
public class plannerController {

    private final MemoService memoService;

    @GetMapping("/{begin}")
    public ModelAndView planner(Memo memo, ModelAndView mv, HttpSession session){

        memo.setId((String)session.getAttribute("id"));
        List<Memo> memoList = memoService.getMemo(memo);
        mv.addObject("memoList",memoList);
        mv.addObject("begin",memo.getBegin());
        mv.setViewName("/planner/planner");
        return mv;
    }

    @GetMapping("/write")
    public ModelAndView writeFrom(HttpSession session, ModelAndView mv,Memo memo){
        String sid = (String)session.getAttribute("id");
        mv.addObject("Data",sid);
        mv.setViewName("planner/Write");
        return mv;
    }

    @PostMapping("/write")
    public String insertMemo(Memo memo, RedirectView rv, HttpSession session, @RequestParam("begin") String begin){
        memo.setBegin(begin);
        memo.setId((String)session.getAttribute("id"));
        memoService.insertMemo(memo);
        return "redirect:/planners/success";
    }

    @GetMapping("/success")
    public ModelAndView success(ModelAndView mv, Memo memo, HttpSession session){
        memo.setId((String)session.getAttribute("id"));
        List<Memo> memoList = memoService.getMemo(memo);
        mv.addObject("memoList",memoList);
        mv.addObject("begin",memo.getBegin());
        mv.setViewName("/planner/planner");
        return mv;
    }

    @GetMapping("/{planno}/Detail")
    public ModelAndView getMemoDetail(ModelAndView mv, Memo memo, HttpSession session){
        memo.setId((String)session.getAttribute("id"));
        Memo memoDetail = memoService.getMemoDetail(memo);

        mv.addObject("memoDetail",memoDetail);
        mv.setViewName("planner/Detail");
        return mv;
    }

    @GetMapping("/{planno}/delete")
    public String deleteMemo(Memo memo, HttpSession session){
        memo.setId((String)session.getAttribute("id"));
        memoService.deleteMemo(memo);

        return "redirect:/planners/success";
    }

    @PostMapping("/{planno}/edit")
    public String updateMemo(Memo memo, HttpSession session){
        memo.setId((String)session.getAttribute("id"));
        memoService.updateMemo(memo);
        return "redirect:/planners/success";
    }

}
