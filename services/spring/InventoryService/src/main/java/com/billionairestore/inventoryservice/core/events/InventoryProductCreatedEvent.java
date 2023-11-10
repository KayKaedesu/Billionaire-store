package com.billionairestore.inventoryservice.core.events;

import lombok.Data;

@Data
public class InventoryProductCreatedEvent {
    private String productId;
}
