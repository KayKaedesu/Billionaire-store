package com.billionairestore.productservice.core.events;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductCreatedEvent {
    private String aggregateId;
    private String productId;
    private String name;
    private String imageUrl;
    private String category;
    private Double buyPrice;
    private Double sellPrice;
}
