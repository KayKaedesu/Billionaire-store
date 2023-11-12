package com.billionairestore.core.events;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BuyProductCreatedEvent {
    private String aggregateId;
    private String logId;
    private String productId;
    private String userId;
    private String name;
    private String category;
    private Double buyPrice;
    private int quantity;
}