package com.todo.Hiplanner.vo;

import lombok.*;
import lombok.experimental.FieldNameConstants;

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
    private String id;
    private String begin;
    private String end;
    private Integer planno;

}
