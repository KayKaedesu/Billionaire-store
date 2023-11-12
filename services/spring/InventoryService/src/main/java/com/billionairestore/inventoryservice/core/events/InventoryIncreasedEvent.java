package com.billionairestore.inventoryservice.core.events;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class InventoryIncreasedEvent {
    private String aggregateId;
    private String productId;
    private int quantity;
}
