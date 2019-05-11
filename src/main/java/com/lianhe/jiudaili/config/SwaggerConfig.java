package com.lianhe.jiudaili.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {
    public ApiInfo createApi(){
        return new ApiInfoBuilder().title("酒代理平台").
                description("本平台为酒水厂商提供优质招商平台，为酒水代理创业者提供安全放心的创业渠道").
                contact(new Contact("龚世杰、徐冲、刘东亮、邵嘉伟、郑鹏飞","http://lianhe.jiudaili.com","lianhejiudaili@163.com")).build();
    }
    @Bean  //等价于 <bean>标签
    public Docket createDoc(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(createApi()).select().
                apis(RequestHandlerSelectors.basePackage("com.lianhe.jiudaili.controller")).build();
    }
}
