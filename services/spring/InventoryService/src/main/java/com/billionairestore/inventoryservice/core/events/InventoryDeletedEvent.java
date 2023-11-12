package com.billionairestore.inventoryservice.core.events;

import lombok.Data;

@Data
public class InventoryDeletedEvent {
    private String aggregateId;
    private String productId;
    private int quantity;
}
