package com.crumbling.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("fwwb_schema.exhibitor")
public class Exhibitor {
    @TableId
    private Long id;
    private String brand;
    private String logourl;
    private String posterurl;
    private String newsinformation;
    private String productinfomation;
    private String other;
}
