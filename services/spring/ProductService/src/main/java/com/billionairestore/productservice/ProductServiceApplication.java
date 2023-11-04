package com.billionairestore.productservice;

import com.billionairestore.productservice.config.RabbitRegisterConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication {

	public static void main(String[] args) {
		RabbitRegisterConfig.registerToRabbit();
		SpringApplication.run(ProductServiceApplication.class, args);
	}

}
