package com.todo.Hiplanner.controller;

import com.todo.Hiplanner.service.MessageService;
import com.todo.Hiplanner.vo.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @GetMapping("/list")
    public ModelAndView getMessages(Message message, ModelAndView mv, HttpSession session){
        message.setRecvId((String)session.getAttribute("id"));
        List<Message> messageList = messageService.selectMessages(message);
        mv.addObject("messageList",messageList);
        mv.setViewName("/message/list");
        return mv;
    }

    @GetMapping("/{mesNo}/message")
    public String detailMessage(Message message, Model model, HttpSession session){
        Message message1 = messageService.detailMessage(message);
        model.addAttribute("message",message1);
        return "/message/detailMessage";
    }

    @PostMapping("/write")
    public String sendMessage(Message message){
        messageService.sendMessage(message);
        return "redirect:/messages/list";
    }

    @GetMapping("/{mesNo}/delete")
    public String deleteMessage(Message message, HttpSession session){
        message.setRecvId((String)session.getAttribute("id"));
        messageService.deleteMessage(message);
        return "redirect:/messages/list";
    }

}
