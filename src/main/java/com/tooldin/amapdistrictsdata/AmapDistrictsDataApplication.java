package com.tooldin.amapdistrictsdata;

import com.tooldin.amapdistrictsdata.component.AmapDistrictComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import tk.mybatis.spring.annotation.MapperScan;

@EnableTransactionManagement
@MapperScan(basePackages = "com.tooldin.amapdistrictsdata.repository")
@SpringBootApplication
public class AmapDistrictsDataApplication {

    @Autowired
    private AmapDistrictComponent amapDistrictComponent;

    public static void main(String[] args) {
        SpringApplication.run(AmapDistrictsDataApplication.class, args);
    }
}
