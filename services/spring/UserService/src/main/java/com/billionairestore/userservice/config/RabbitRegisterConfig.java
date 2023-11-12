package com.billionairestore.userservice.config;

import com.billionairestore.core.rabbit.RabbitExchangeConfigurator;
import com.billionairestore.core.rabbit.RabbitQueue;
import com.billionairestore.core.rabbit.RabbitServiceRegistration;

import java.util.ArrayList;
import java.util.Arrays;

public class RabbitRegisterConfig {
    public static final String exchangeName = "user-service";
    public static final RabbitQueue GET_ALL_QUEUE = new RabbitQueue("get-all", "get-all");

    public static void registerToRabbit() {
        RabbitServiceRegistration registration = new RabbitServiceRegistration(RabbitRegisterConfig.exchangeName,  new ArrayList<>(
                Arrays.asList(RabbitRegisterConfig.GET_ALL_QUEUE)
        ));
        RabbitExchangeConfigurator.initialize(registration);
    }
}
