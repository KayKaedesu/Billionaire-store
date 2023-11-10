package com.billionairestore.inventoryservice.core.events;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class InventoryProductDeletedEvent {
    private String productId;
}
