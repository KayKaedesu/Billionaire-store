package com.billionairestore.core.events;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BuyProductCreatedEvent {
    private final String aggregateId;
    private final String logId;
    private final String productId;
    private final String userId;
    private final String name;
    private final String category;
    private final Double buyPrice;
    private final int quantity;
}