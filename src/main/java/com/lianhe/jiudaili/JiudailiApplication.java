package com.lianhe.jiudaili;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2 //启用Swagger
@MapperScan("com.lianhe.jiudaili.dao")
public class JiudailiApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(JiudailiApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(JiudailiApplication.class);
    }
}
