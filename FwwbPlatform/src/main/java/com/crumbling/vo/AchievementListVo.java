package com.crumbling.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AchievementListVo {
    private Long id;
    private String productName;
    private String productDescription;
    private String pictureUrl;
}
