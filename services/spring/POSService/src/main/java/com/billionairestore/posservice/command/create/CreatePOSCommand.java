package com.billionairestore.posservice.command.create;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.lang.reflect.Array;

@Builder
@Data
public class CreatePOSCommand {
    @TargetAggregateIdentifier
    private final String aggregateId;
    private final String POSId;
    private final String userId;
    private final Array productList;
}
