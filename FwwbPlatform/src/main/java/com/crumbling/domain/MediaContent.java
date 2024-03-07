package com.crumbling.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("fwwb_schema.MediaContent")
public class MediaContent {
    @TableId
    private Long id;
    private Long type;
    private String content;
    private String pictureUrl;
    private String summary;
    private String title;
    private String other;
}
