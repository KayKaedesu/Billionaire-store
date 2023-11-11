package com.billionairestore.shelfservice.core.events;

import lombok.Data;

@Data
public class ShelfUpdatedEvent {
    private String aggregateId;
//    private String shelfId;
    private String productId;
    private int quantity;
}
