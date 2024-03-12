package com.crumbling.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventCountListVo {
    private Long id;
    private Long subscribersCount;
}
