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
public class Memo {

    private Long do_num;
    private String title;
    private String content;
    private Date wdate;
    private Date udate;
    private Date ddate;
    private String username;
    private String begin;
    private String end;
    private Integer planno;

}
