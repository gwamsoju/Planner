package com.todo.Hiplanner.vo;

import lombok.*;

import java.sql.Date;
import java.time.LocalDate;

@Data
public class Memo {

    private long do_num;
    private String title;
    private String content;
    private Date wdate;
    private Date udate;
    private Date ddate;
    private String id;
    private String begin;
    private String end;
    private int planno;

}
