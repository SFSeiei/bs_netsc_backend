package com.tjpu.bs.netsc;

import io.swagger.annotations.BasicAuthDefinition;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@MapperScan("com.tjpu.bs.netsc.mapper")
public class NetscApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(NetscApplication.class, args);
    }
    // 继承SpringBootServletInitializer 实现configure 方便打war 外部服务器部署。
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(NetscApplication.class);
    }

}
