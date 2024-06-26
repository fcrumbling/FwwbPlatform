package com.crumbling.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("fwwb_schema.Users")
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String userName;
    private String password;
    private String gender;
    private String phoneNumber;
    private String nickName;
    private String admin;
    private String email;
    private java.sql.Timestamp createTime;
    private java.sql.Timestamp updateTime;
    private String createBy;
    private String updateBy;
    private Integer delFlag;
}
