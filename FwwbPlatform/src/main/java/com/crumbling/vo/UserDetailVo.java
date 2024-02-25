package com.crumbling.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetailVo {
    private Long userId;
    private String userName;
    private String password;
    private String name;
    private String gender;
    private String contrctInfo;
    private java.sql.Timestamp registrationTime;
    private String admin;
}
