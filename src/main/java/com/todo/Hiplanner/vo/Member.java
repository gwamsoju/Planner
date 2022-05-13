package com.todo.Hiplanner.vo;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    private String id;
    private String name;
    private String pwd;
    private String job;
    private String mail;
    private String phone;

}
