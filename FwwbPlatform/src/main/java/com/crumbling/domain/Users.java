package com.crumbling.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("fwwb_schema.Users")
public class Users {
  @TableId
  private Long userId;
  private String userName;
  private String password;
  private String name;
  private String gender;
  private String contrctInfo;
  private java.sql.Timestamp registrationTime;
  private String admin;
  private String other;

}
