package com.todo.Hiplanner.vo;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {

    private String id;
    private String name;
    private String pwd;
    private String job;
    private String mail;
    private String phone;
    private String gender;

    @Builder
    public Member(String id, String pwd, String mail, String phone) {
        this.id = id;
        this.pwd = pwd;
        this.mail = mail;
        this.phone = phone;
    }

}
