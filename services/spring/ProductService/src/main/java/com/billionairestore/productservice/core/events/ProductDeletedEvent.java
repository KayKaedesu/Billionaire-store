package com.billionairestore.productservice.core.events;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
public class ProductDeletedEvent {
    private String aggregateId;
    private String productId;
}
