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
@TableName("fwwb_schema.Register")
public class Register {
  @TableId(type = IdType.AUTO)
  private Long id;
  private Long eventid;
  private Long userid;
}
