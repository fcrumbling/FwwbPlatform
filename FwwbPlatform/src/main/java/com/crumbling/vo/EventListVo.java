package com.crumbling.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventListVo {
    private Long eventId;
    private String eventName;
    private java.sql.Timestamp eventTime;
    private String eventLocation;
    private String eventContent;
    private String isLive;
    private String videoreplayLink;
    private Long subscribersCount;
    private Long eventPopularity;
    private Long type;
    private java.sql.Timestamp eventEndTime;
    private String pictureUrl;
}
