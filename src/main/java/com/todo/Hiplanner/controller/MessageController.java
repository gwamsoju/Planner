package com.todo.Hiplanner.controller;

import com.todo.Hiplanner.service.MemberService;
import com.todo.Hiplanner.service.MessageService;
import com.todo.Hiplanner.vo.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;
    private final MemberService memberService;

    @GetMapping("/{id}")
    public ModelAndView getMessages(Message message, ModelAndView mv, HttpSession session){
        message.setRecvId((String)session.getAttribute("id"));
        List<Message> messageList = messageService.selectMessages(message);
        mv.addObject("messageList",messageList);
        mv.setViewName("/message/message");
        return mv;
    }

    @ResponseBody
    @GetMapping("/SearchSuggest")
    public List<String> SearchSuggest(String id, HttpSession session){
        id = (String)session.getAttribute("id");
        List<String> userIds = memberService.SearchSuggest(id);
        return userIds;
    }

    @GetMapping("/message")
    public ModelAndView detailMessage(Message message, ModelAndView mv, HttpSession session){
        message.setRecvId((String)session.getAttribute("id"));
        Message message1 = messageService.detailMessage(message);
        mv.addObject("message",message1);
        mv.setViewName("/message/detailMessage");
        return mv;
    }

    @PostMapping("/write")
    public String sendMessage(Message message){
        messageService.sendMessage(message);
        return "redirect:/messages/success";
    }
}
