package com.todo.Hiplanner.controller;

import com.todo.Hiplanner.service.MessageService;
import com.todo.Hiplanner.vo.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping("/write")
    public String sendMessage(Message message){
        messageService.sendMessage(message);
        return "redirect:/messages/success";
    }
}
