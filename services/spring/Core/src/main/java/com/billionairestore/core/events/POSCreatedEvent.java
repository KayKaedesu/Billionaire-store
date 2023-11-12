package com.billionairestore.core.events;

import lombok.Builder;
import lombok.Data;

import java.lang.reflect.Array;

@Data
@Builder
public class POSCreatedEvent {
    private String aggregateId;
    private String POSId;
    private String userId;
    private Array productList;
}
