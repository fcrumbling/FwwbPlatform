package com.crumbling.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddEventDto {
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
    private String other;
}
