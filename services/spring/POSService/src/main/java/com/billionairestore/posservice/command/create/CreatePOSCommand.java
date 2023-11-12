package com.billionairestore.posservice.command.create;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.lang.reflect.Array;
import java.util.List;

@Builder
@Data
public class CreatePOSCommand {
    @TargetAggregateIdentifier
    private final String aggregateId;
//    private final String POSId;
    private final String userId;
    private final List<Object> productList;
}
