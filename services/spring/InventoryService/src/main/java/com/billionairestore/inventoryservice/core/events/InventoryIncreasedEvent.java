package com.billionairestore.inventoryservice.core.events;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InventoryIncreasedEvent {
    private String productId;
    private int quantity;
}
