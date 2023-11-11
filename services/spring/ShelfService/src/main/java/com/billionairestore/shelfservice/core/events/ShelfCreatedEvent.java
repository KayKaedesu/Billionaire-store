package com.billionairestore.shelfservice.core.events;

import lombok.Data;

@Data
public class ShelfCreatedEvent {
    private String aggregateId;
//    private String shelfId;
    private String productId;
    private int quantity;
}
