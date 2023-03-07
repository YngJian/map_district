package com.tooldin.amapdistrictsdata.dto;

import lombok.Data;

import java.util.List;

/**
 * @Author: williamsuen
 * @Date: 2018-06-07 20:41
 */
@Data
public class AmapDistrictResult {

    private String status;
    private String info;
    private String infocode;
    private String count;
    private List<AmapDistrictDto> districts;

}
