package com.billionairestore.shelfservice.command.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Builder
@Data
public class DeleteShelfCommand {
    @TargetAggregateIdentifier
    private final String aggregateId;
//    private final String shelfId;
    private final String productId;
    private final int quantity;
}
