package com.todo.Hiplanner.vo;

import lombok.*;

//TODO: @Builder 어노테이션 사용하여 테스트 코드 변경 예정.
@Data
public class Member {

    private String id;
    private String name;
    private String pwd;
    private String job;
    private String mail;
    private String phone;
    private String gender;
}
