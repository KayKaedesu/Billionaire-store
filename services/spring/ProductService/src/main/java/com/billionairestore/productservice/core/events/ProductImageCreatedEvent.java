package com.billionairestore.productservice.core.events;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@AllArgsConstructor
public class ProductImageCreatedEvent {
    @TargetAggregateIdentifier
    private String aggregateId;
    private String productId;
    private String imagePath;
}
