package com.billionairestore.inventoryservice.query.rest;

import lombok.Data;

@Data
public class InventoryRestModel {
    private String productId;
    private int quantity;
}
