package com.crumbling.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExhibitorDetailVo {
    private Long id;
    private String brand;
    private String logourl;
    private String posterurl;
    private String newsinformation;
    private String productinfomation;
}
