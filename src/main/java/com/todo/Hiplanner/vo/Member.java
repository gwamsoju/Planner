package com.todo.Hiplanner.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Member {

    private String username;
    private String name;
    private String password;
    private String job;
    private String mail;
    private String phone;
    private String gender;
    private String role;

}
