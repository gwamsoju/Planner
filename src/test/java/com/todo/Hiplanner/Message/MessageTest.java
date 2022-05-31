package com.todo.Hiplanner.Message;

import com.todo.Hiplanner.mapper.MessageMapper;
import com.todo.Hiplanner.service.MessageService;
import com.todo.Hiplanner.vo.Message;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class MessageTest {

    @Autowired
    private MessageService messageService;

    @Test
    public void 쪽지_보내기(){
        //given
        Message message = Message.builder()
                        .mesCon("안녕하세요.")
                        .recvId("ckdrl")
                        .sendId("wodud")
                        .mesNo(1)
                        .isShow("Y")
                        .build();
        //when
        messageService.sendMessage(message);
        List<Message> messages = messageService.selectMessages(message);
        //then
        assertThat(messages.size()).isEqualTo(1);

    }

    @Test
    public void 쪽지_리스트에서_원하는_쪽지_가져오기(){
        //given
        Message message = Message.builder()
                        .mesNo(1)
                        .build();
        //when
        Message message1 = messageService.detailMessage(message);
        //then
        assertThat(message1.getMesNo()).isEqualTo(1);
    }

    @Test
    public void 쪽지_삭제(){
        //given
        Message message = Message.builder()
                        .recvId("ckdrl")
                        .sendId("wodud")
                        .mesNo(1)
                        .isShow("Y")
                        .build();
        //when
        messageService.deleteMessage(message);
        List<Message> messages = messageService.selectMessages(message);
        //then
        assertThat(messages.size()).isEqualTo(0);
    }

}
