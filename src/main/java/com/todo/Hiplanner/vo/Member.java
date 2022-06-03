package com.todo.Hiplanner.vo;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {

    private String id;
    private String name;
    private String pwd;
    private String job;
    private String mail;
    private String phone;
    private String gender;


}
