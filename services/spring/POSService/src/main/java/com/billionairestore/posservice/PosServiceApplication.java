package com.billionairestore.posservice;

import com.billionairestore.core.AxonXstreamConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({AxonXstreamConfig.class})
public class PosServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PosServiceApplication.class, args);
	}

}
