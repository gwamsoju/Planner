package com.todo.Hiplanner.service;

import com.todo.Hiplanner.vo.Message;

import java.util.List;

public interface MessageService {

    public void sendMessage(Message message);
    public List<Message> selectMessages(Message message);
    public Message detailMessage(Message message);
    public void deleteMessage(Message message);
}
