package com.todo.Hiplanner.vo;

import lombok.*;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private Integer mesNo;
    private String mesCon;
    private Date createdAt;
    private String sendId;
    private String recvId;
    private String isShow;

    @Builder
    public Message(Integer mesNo, String mesCon, String sendId, String recvId,String isShow){
        this.mesNo = mesNo;
        this.mesCon = mesCon;
        this.sendId = sendId;
        this.recvId = recvId;
        this.isShow = isShow;
    }
}
