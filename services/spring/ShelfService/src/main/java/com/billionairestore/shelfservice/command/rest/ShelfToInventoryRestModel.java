package com.billionairestore.shelfservice.command.rest;

import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
public class ShelfToInventoryRestModel {
    @TargetAggregateIdentifier
    private final String aggregateId;
    private final String productId;
    private final int quantity;
}
