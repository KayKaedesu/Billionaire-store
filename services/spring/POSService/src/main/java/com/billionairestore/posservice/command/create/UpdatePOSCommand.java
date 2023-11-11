package com.billionairestore.posservice.command.create;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
@Builder
@Data
public class UpdatePOSCommand {
    @TargetAggregateIdentifier
    private final String aggregateId;
    private final String POSId;
    private final String employeeId;
    private final String productId;
    private final String sellPrice;
    private final String quantity;
}
