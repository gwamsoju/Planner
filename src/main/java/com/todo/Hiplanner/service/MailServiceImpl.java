package com.todo.Hiplanner.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.internet.MimeMessage;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements MailService {

    private final JavaMailSender javaMailSender;

    private static int confirmNumber ;

    // 인증 번호 생성 메서드
    public static void confirmNumber(){
        Random random = new Random();
        int i = random.nextInt(9999);

        confirmNumber = i;
    }

    // 이메일 작성 메서드
    public MimeMessage createMail(String id)throws Exception{
        confirmNumber();
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        // 수신자 메일 정보
        mimeMessage.addRecipients(Message.RecipientType.TO, id);
        // 메일 제목
        mimeMessage.setSubject("Hi Planner 인증 메일입니다.");

        String msg = "";
        msg += "안녕하세요! Hi Planner 입니다.";
        msg += "<br>";
        msg += "요청하신 이메일 인증 번호입니다. 아래 번호를 입력해주세요!";
        msg += "<br><br><br>";
        msg += "<h1>" + confirmNumber + "<h1><br>";
        msg += "Hi Planner를 이용해주셔서 감사합니다.";

        mimeMessage.setText(msg,"UTF-8","html");
        return mimeMessage;
    }

    // 이메일 전송 메서드
    @Override
    public int sendEmail(String id) throws Exception {
        MimeMessage mail = createMail(id);

        try{
            javaMailSender.send(mail);
        }catch(MailException e){
            e.printStackTrace();
        }
        return confirmNumber;
    }

}
