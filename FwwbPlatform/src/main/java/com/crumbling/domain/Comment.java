package com.crumbling.domain;


import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("fwwb_schema.Comment")
public class Comment {
  @TableId(type = IdType.AUTO)
  private Long id;
  private Long eventId;
  private Long rootId;
  private String content;
  private Long toCommentUserId;
  private Long toCommentId;
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Long createBy;
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date createTime;
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Long updateBy;
  @TableField(fill = FieldFill.INSERT_UPDATE)
  private Date updateTime;
  private Long delFlag;
}
