package com.billionairestore.shelfservice;

import com.billionairestore.core.AxonXstreamConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@EnableDiscoveryClient
@SpringBootApplication
@Import({AxonXstreamConfig.class})
public class ShelfServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShelfServiceApplication.class, args);
	}

}
