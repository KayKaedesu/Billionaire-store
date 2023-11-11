package com.billionairestore.productservice.core.events;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@NoArgsConstructor
public class ProductPutEvent {
    @TargetAggregateIdentifier
    private String aggregateId;
    private String productId;
    private String name;
    private String imageUrl;
    private String category;
    private Double buyPrice;
    private Double sellPrice;
}
