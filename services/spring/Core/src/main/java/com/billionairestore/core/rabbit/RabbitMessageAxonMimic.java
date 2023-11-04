package com.billionairestore.core.rabbit;

public interface RabbitMessageAxonMimic {
    String getQueueName();
    String getRoutingKey();
}
