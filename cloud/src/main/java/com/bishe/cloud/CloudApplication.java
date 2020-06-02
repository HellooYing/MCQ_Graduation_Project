package com.bishe.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@tk.mybatis.spring.annotation.MapperScan(basePackages = "com.bishe.cloud.dao")
public class CloudApplication  extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(CloudApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(CloudApplication.class, args);
    }
}
