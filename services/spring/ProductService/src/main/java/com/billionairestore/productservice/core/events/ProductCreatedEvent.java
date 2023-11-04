package com.billionairestore.productservice.core.events;

import lombok.Builder;
import lombok.Data;

@Data
public class ProductCreatedEvent {
    private String productId;
    private String name;
    private String imageUrl;
    private String category;
    private Double buyPrice;
    private Double sellPrice;
}
