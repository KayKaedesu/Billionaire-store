package com.billionairestore.posservice.core.events;

import lombok.Data;

@Data
public class POSDeletedEvent {
    private final String aggregateId;
    private final String POSId;
    private final String employeeId;
    private final String productId;
    private final String sellPrice;
    private final String quantity;
}
