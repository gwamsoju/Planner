package com.todo.Hiplanner.mapper;

import com.todo.Hiplanner.vo.Message;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MessageMapper {

    public void sendMessage(Message message);
    public List<Message> selectMessages(Message message);
    public Message detailMessage(Message message);
    public void deleteMessage(Message message);
}
