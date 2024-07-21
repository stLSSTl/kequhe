package com.science;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.science.mapper")
@EnableTransactionManagement //开启注解方式的事务管理
@Slf4j
public class MultimediaApplication {
    public static void main(String[] args) {
        SpringApplication.run(MultimediaApplication.class, args);
    }

}
