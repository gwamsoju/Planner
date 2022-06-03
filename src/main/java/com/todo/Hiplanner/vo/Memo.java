package com.todo.Hiplanner.vo;

import lombok.*;
import lombok.experimental.FieldNameConstants;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

    @Builder
    public Memo(String title, String content, String id, String begin, String end, Integer planno) {
        this.title = title;
        this.content = content;
        this.id = id;
        this.begin = begin;
        this.end = end;
        this.planno = planno;
    }
}
