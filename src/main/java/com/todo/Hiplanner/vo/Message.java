package com.todo.Hiplanner.vo;

import lombok.Data;

import java.sql.Date;

@Data
public class Message {
    private int mesNo;
    private String mesCon;
    private Date createdAt;
    private String sendId;
    private String recvId;
    private String isShow;
}
