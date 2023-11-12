package com.billionairestore.productservice.core.events;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductImageCreatedEvent {

    private String aggregateId;
    private String productId;
    private String imagePath;
}
