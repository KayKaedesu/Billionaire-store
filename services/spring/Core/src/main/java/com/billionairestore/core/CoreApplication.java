package com.billionairestore.core;

import com.billionairestore.core.rabbit.RabbitExchangeConfigurator;
import com.billionairestore.core.rabbit.RabbitQueue;
import com.billionairestore.core.rabbit.RabbitServiceRegistration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;

@SpringBootApplication
public class CoreApplication {

	public static void main(String[] args) {
		RabbitQueue queue = new RabbitQueue("Test", "Test");
		RabbitQueue queue2 = new RabbitQueue("Test2", "Test2");
		ArrayList<RabbitQueue> queues = new ArrayList<>();
		queues.add(queue);
		queues.add(queue2);
		RabbitServiceRegistration registration = new RabbitServiceRegistration("Test", queues);
		RabbitExchangeConfigurator.initialize(registration);
		SpringApplication.run(CoreApplication.class, args);
	}

}
