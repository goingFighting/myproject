package com.elitesland.userdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.elitesland.userdemo.dao")

public class UserdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserdemoApplication.class, args);
    }
}
