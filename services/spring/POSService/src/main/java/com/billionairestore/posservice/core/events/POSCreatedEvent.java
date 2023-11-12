package com.billionairestore.posservice.core.events;

import lombok.Data;

import java.lang.reflect.Array;

@Data
public class POSCreatedEvent {
    private final String aggregateId;
    private final String POSId;
    private final String userId;
    private final Array productList;
}
