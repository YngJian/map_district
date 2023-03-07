package com.tooldin.amapdistrictsdata.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author: williamsuen
 * @Date: 2018-06-08 12:09
 */
@Data
@Table(name = "amap_district")
public class AmapDistrict {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String citycode;

    private String adcode;

    private String name;

    private String center;

    private String level;

    @Column(name = "parent_id")
    private Integer parentId;

}
