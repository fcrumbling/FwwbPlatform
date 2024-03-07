package com.crumbling.vo;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class UserInfoVo {
    private Long id;
    private String phoneNumber;
    private String gender;
    private String nickName;
    private String email;
    private String admin;

}