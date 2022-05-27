package com.todo.Hiplanner.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    private int mes_no;
    private String mes_con;
    private Date wdate;
    private String read_check;
    private String send_id;
    private String recv_id;
    private String isshow;

}
