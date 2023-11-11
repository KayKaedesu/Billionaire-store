package com.billionairestore.shelfservice.core.events;

import lombok.Data;

@Data
public class ShelfUpdatedEvent {
    private String aggregateId;
    private String productId;
    private String amount;
}
