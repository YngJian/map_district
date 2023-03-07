package com.tooldin.amapdistrictsdata.component;

import com.alibaba.fastjson.JSON;
import com.tooldin.amapdistrictsdata.dto.AmapDistrictDto;
import com.tooldin.amapdistrictsdata.dto.AmapDistrictResult;
import com.tooldin.amapdistrictsdata.entity.AmapDistrict;
import com.tooldin.amapdistrictsdata.properties.AmapProperties;
import com.tooldin.amapdistrictsdata.repository.DistrictMapper;
import com.tooldin.amapdistrictsdata.utils.HttpClientUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: williamsuen
 * https://lbs.amap.com/api/webservice/guide/api/district/
 * @Date: 2018-06-07 19:17
 */
@Component("amapDistrict")
public class AmapDistrictComponent {

    @Autowired
    private AmapProperties amapProperties;

    @Autowired
    private DistrictMapper districtMapper;

    private String apiurl = "http://restapi.amap.com/v3/config/district";

    /**
     * 行政区域查询 -
     * http://lbs.amap.com/api/webservice/guide/api/district
     */
    @Transactional(rollbackFor = Exception.class)
    public void district() {
        // 先查询省
        AmapDistrictResult result = search("100000", "1");
        List<AmapDistrictDto> provinceList = result.getDistricts().get(0).getDistricts();
        provinceList.forEach(province -> {
            AmapDistrictResult provinceResult = search(province.getAdcode(), "3");
            insertDistrict(provinceResult.getDistricts(), null);
        });
    }

    private AmapDistrictResult search(String keywords, String subdistrict) {
        Map<String, String> params = new HashMap<>(3);
        params.put("key", amapProperties.getKey());
        params.put("keywords", keywords);
        params.put("subdistrict", subdistrict);

        String result = HttpClientUtils.doGet(apiurl, params);
        return JSON.parseObject(result, AmapDistrictResult.class);
    }

    private void insertDistrict(List<AmapDistrictDto> data, Integer parentId) {
        data.forEach(child -> {
            AmapDistrict district = new AmapDistrict();
            BeanUtils.copyProperties(child, district);
            district.setParentId(parentId);
            if ("province".equals(district.getLevel())) district.setLevel("1");
            if ("city".equals(district.getLevel())) district.setLevel("2");
            if ("district".equals(district.getLevel())) district.setLevel("3");
            if ("street".equals(district.getLevel())) district.setLevel("4");
            districtMapper.insert(district);
            List<AmapDistrictDto> subCList = child.getDistricts();
            if (subCList != null && !subCList.isEmpty()) {
                insertDistrict(subCList, district.getId());
            }
        });
    }

}
