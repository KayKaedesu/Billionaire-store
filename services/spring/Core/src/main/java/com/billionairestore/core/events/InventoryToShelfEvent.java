package com.billionairestore.core.events;

import lombok.Data;

@Data
public class InventoryToShelfEvent {
    private String aggregateId;
    private String productId;
    private int quantity;
}
