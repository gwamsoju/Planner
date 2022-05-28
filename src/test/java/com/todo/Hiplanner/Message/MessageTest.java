package com.todo.Hiplanner.Message;

import com.todo.Hiplanner.mapper.MessageMapper;
import com.todo.Hiplanner.service.MessageService;
import com.todo.Hiplanner.vo.Message;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MessageTest {

    @Autowired
    private MessageService messageService;

    @Test
    public void 쪽지_보내기(){
        //given
        Message message = new Message();
        message.setMes_con("안녕하세요");
        message.setSend_id("dlwodud");
        message.setRecv_id("wodud");
        message.setIsShow("Y");
        //when
        messageService.sendMessage(message);
        List<Message> messages = messageService.selectMessages(message);
        //then
        assertThat(messages.size()).isEqualTo(1);
    }

    @Test
    public void 쪽지_삭제(){
        //given
        Message message = new Message();
        message.setRecv_id("ckdrl");
        message.setSend_id("wodud");
        message.setMes_no(1);
        message.setIsShow("Y");
        //when
        messageService.deleteMessage(message);
        List<Message> messages = messageService.selectMessages(message);
        //then
        assertThat(messages.size()).isEqualTo(0);
    }

}
