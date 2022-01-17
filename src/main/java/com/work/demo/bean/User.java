package com.work.demo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private  Integer id;
    private String userCode;
    private String userName;
    private String password;
    private Integer gender;
    private String phone;
    private String address;
    private Integer userRole;
}
