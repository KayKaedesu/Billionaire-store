package com.billionairestore.inventoryservice.command.commands;


import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Builder
@Data
public class CreateInventoryCommand {
    @TargetAggregateIdentifier
    private final String aggregateId;
    private final String productId;
    private final int quantity;
}
