package com.billionairestore.shelfservice.command.create;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Builder
@Data
public class CreateShelfCommand {
    @TargetAggregateIdentifier
    private final String aggregateId;
    private final String productId;
    private final String amount;
}
