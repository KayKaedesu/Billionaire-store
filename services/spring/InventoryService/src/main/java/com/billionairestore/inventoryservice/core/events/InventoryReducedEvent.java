package com.billionairestore.inventoryservice.core.events;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class InventoryReducedEvent {
    private String aggregateId;
    private String productId;
    private int quantity;
}
