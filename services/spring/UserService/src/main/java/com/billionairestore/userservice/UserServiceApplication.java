package com.billionairestore.userservice;

import com.billionairestore.userservice.config.RabbitRegisterConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceApplication {
    public static void main(String[] args) {
        RabbitRegisterConfig.registerToRabbit();
        SpringApplication.run(UserServiceApplication.class, args);
    }

}
