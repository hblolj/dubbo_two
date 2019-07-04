package com.hblolj.dubbo.two.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

/**
 * @author: hblolj
 * @Date: 2019/7/4 10:25
 * @Description:
 * @Version:
 **/
@SpringBootApplication
@ImportResource(value = {"classpath:/spring/spring-jdbc.xml", "classpath:/spring/spring-dubbo.xml"})
@MapperScan(basePackages = "com.hblolj.dubbo.two.model.mappers")
public class BootMoreApplication extends SpringBootServletInitializer{

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(BootMoreApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(BootMoreApplication.class, args);
    }
}
