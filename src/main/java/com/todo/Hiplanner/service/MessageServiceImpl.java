package com.todo.Hiplanner.service;

import com.todo.Hiplanner.mapper.MessageMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService{

    private final MessageMapper messageMapper;


}
