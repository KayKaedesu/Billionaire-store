package com.billionairestore.core.events;

import lombok.Data;

@Data
public class ShelfToInventoryEvent {
    private String aggregateId;
    private String productId;
    private int quantity;
}
