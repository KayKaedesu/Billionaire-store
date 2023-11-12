package com.billionairestore.core.events;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ProductPutEvent {
    private String aggregateId;
    private String productId;
    private String name;
    private String imageUrl;
    private String category;
    private Double buyPrice;
    private Double sellPrice;
}
