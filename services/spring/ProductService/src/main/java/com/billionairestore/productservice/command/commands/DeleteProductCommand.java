package com.billionairestore.productservice.command.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class DeleteProductCommand {
    @TargetAggregateIdentifier
    private final String aggregateId;
    private final String productId;
}
