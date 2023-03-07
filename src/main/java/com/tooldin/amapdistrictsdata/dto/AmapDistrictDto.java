package com.tooldin.amapdistrictsdata.dto;

import lombok.Data;

import java.util.List;

/**
 * @Author: williamsuen
 * @Date: 2018-06-07 20:43
 */
@Data
public class AmapDistrictDto {

    private String citycode;
    private String adcode;
    private String name;
    private String center;
    private String level;
    private List<AmapDistrictDto> districts;

}
