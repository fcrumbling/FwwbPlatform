package com.crumbling.domain;

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
  @TableId
  private Long id;
  private String userName;
  private String password;
  private String gender;
  private String phoneNumber;
  private String nickName;
  private String admin;
  private String email;
  private String other;
}
