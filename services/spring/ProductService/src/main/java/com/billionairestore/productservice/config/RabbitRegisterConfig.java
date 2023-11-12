package com.billionairestore.productservice.config;

import com.billionairestore.core.rabbit.RabbitExchangeConfigurator;
import com.billionairestore.core.rabbit.RabbitQueue;
import com.billionairestore.core.rabbit.RabbitServiceRegistration;

import java.util.ArrayList;
import java.util.Arrays;

public class RabbitRegisterConfig {
    public static String exchangeName = "product-service";
    public static ArrayList<RabbitQueue> queues = new ArrayList<>(
            Arrays.asList(
                    new RabbitQueue("create-product", "create-product"),
                    new RabbitQueue("delete-product", "delete-product")
            )
    );

    public static void registerToRabbit() {
        RabbitServiceRegistration registration = new RabbitServiceRegistration(RabbitRegisterConfig.exchangeName, RabbitRegisterConfig.queues);
        RabbitExchangeConfigurator.initialize(registration);
    }
}
