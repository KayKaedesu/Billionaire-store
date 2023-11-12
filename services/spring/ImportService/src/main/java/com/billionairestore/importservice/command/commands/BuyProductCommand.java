package com.billionairestore.importservice.command.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class BuyProductCommand {
    @TargetAggregateIdentifier
    private final String aggregateId;
    private final String productId;
    private final String name;
    private final String category;
    private final Double buyPrice;
    private final Double quantity;
}
