package com.tooldin.amapdistrictsdata.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: williamsuen
 * @Date: 2018-06-07 19:11
 */
@Data
@Component
@ConfigurationProperties(prefix = "amap")
public class AmapProperties {

    private String key;

}
