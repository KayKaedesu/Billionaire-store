package com.billionairestore.core.events;

import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class CreatedEvent {
    private final String aggregateId;
    private final String productId;
    private final String name;
    private final String imageUrl;
    private final String category;
    private final Double buyPrice;
    private final Double sellPrice;
}
