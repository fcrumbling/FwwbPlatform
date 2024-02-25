package com.crumbling.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("fwwb_schema.Achievement")
public class Achievement {
  @TableId
  private Long id;
  private String productName;
  private String productDescription;
  private String pictureUrl;
  private String other;
}
