package com.funi.muyq.angular.zorroserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.funi.muyq.angular.zorroserver.mapper")
public class ZorroServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZorroServerApplication.class, args);
    }
}
