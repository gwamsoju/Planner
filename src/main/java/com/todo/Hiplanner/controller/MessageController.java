package com.todo.Hiplanner.controller;

import com.todo.Hiplanner.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {

    private MessageService messageService;

    @GetMapping("/message")
    public String getMessages(){
        return "message/message";
    }
}
