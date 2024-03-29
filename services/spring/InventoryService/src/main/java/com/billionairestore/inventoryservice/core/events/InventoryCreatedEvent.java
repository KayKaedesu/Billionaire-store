package com.billionairestore.inventoryservice.core.events;

import lombok.Builder;
import lombok.Data;

@Data
public class InventoryCreatedEvent {
    private String aggregateId;
    private String productId;
    private int quantity;
}
