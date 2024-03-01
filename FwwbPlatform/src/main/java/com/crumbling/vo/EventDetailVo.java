package com.crumbling.vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventDetailVo {
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
}
