package com.billionairestore.productservice.config;

import com.billionairestore.core.rabbit.RabbitExchangeConfigurator;
import com.billionairestore.core.rabbit.RabbitQueue;
import com.billionairestore.core.rabbit.RabbitServiceRegistration;

import java.util.ArrayList;

public class RabbitRegisterConfig {
    public static void registerToRabbit() {
        ArrayList<RabbitQueue> queues = new ArrayList<>();
        queues.add(new RabbitQueue("create-product", "create-product"));
        RabbitServiceRegistration registration = new RabbitServiceRegistration("ProductService", queues);
        RabbitExchangeConfigurator.initialize(registration);
    }
}
