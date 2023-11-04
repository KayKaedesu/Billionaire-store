package com.billionairestore.core.rabbit.command;

import com.billionairestore.core.rabbit.RabbitMessageAxonMimic;

public class RabbitCommand implements RabbitMessageAxonMimic {
    private String queueName;
    private String routingKey;

    public RabbitCommand(String queueName, String routingKey) {
        this.queueName = queueName;
        this.routingKey = routingKey;
    }

    @Override
    public String getQueueName() {
        return queueName;
    }

    @Override
    public String getRoutingKey() {
        return routingKey;
    }
}
