package com.sozkandev.configserver1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaServer
public class ConfigServer1Application {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServer1Application.class, args);
    }

}