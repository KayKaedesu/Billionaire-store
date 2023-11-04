package com.billionairestore.core.rabbit;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class RabbitServiceRegistration {
    private String exchangeName;
    private List<RabbitQueue> queues;

}
