package com.billionairestore.reportservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ReportServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReportServiceApplication.class, args);
	}

}
