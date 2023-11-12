package com.billionairestore.productservice;

import com.billionairestore.core.AxonXstreamConfig;
import com.billionairestore.productservice.config.RabbitRegisterConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@EnableDiscoveryClient
@SpringBootApplication
@Import({AxonXstreamConfig.class})
public class ProductServiceApplication {
	public static void main(String[] args) {
		RabbitRegisterConfig.registerToRabbit();
		SpringApplication.run(ProductServiceApplication.class, args);
	}
}
