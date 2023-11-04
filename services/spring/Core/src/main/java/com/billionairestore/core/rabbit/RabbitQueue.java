package com.billionairestore.core.rabbit;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RabbitQueue {
    private String queueName;
    private String routingKey;
}
