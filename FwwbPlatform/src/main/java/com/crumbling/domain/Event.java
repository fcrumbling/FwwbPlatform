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
@TableName("fwwb_schema.Event")
public class Event {
  @TableId(type = IdType.AUTO)
  private Long id;
  private String eventName;
  private java.sql.Timestamp eventTime;
  private String eventLocation;
  private String eventContent;
  private String isLive;
  private String videoreplayLink;
  private Long subscribersCount;
  private Long eventPopularity;
  private String pictureUrl;
  private Long type;
  private java.sql.Timestamp eventEndTime;
  private Integer delFlag;
}
