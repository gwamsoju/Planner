package com.todo.Hiplanner.service;

import com.todo.Hiplanner.mapper.MessageMapper;
import com.todo.Hiplanner.vo.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService{

    private final MessageMapper messageMapper;


    @Override
    public void sendMessage(Message message) {
        messageMapper.sendMessage(message);
    }

    @Override
    public List<Message> selectMessages(Message message) {
        return messageMapper.selectMessages(message);
    }

    @Override
    public Message detailMessage(Message message) {
        return messageMapper.detailMessage(message);
    }

    @Override
    public void deleteMessage(Message message) {
        messageMapper.deleteMessage(message);
    }
}
