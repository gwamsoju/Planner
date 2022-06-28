package com.todo.Hiplanner.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
