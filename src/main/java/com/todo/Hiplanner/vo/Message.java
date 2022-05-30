package com.todo.Hiplanner.vo;

import lombok.*;

import java.sql.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Message {

    private int mesNo;
    private String mesCon;
    private Date createAt;
    private String readCheck;
    private String sendId;
    private String recvId;
    private String isShow;

}
