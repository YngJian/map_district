package com.tooldin.amapdistrictsdata.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

/**
 * @Author: williamsuen
 * @Date: 2018-06-07 19:29
 */
@Component
public class AmapApplicationRunner implements ApplicationRunner {

    @Autowired
    private AmapDistrictComponent amapDistrictComponent;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        amapDistrictComponent.district();
    }
}
