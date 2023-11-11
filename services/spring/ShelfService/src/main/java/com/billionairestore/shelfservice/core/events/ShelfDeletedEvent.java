package com.billionairestore.shelfservice.core.events;

import lombok.Data;

@Data
public class ShelfDeletedEvent {
    private String aggregateId;
//    private String shelfId;
    private String productId;
    private int quantity;
}
