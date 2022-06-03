package com.todo.Hiplanner.vo;

import lombok.*;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Message {
    private Integer mesNo;
    private String mesCon;
    private Date createdAt;
    private String sendId;
    private String recvId;
    private String isShow;

}
