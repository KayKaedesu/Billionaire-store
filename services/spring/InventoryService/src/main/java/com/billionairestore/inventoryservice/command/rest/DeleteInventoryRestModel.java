package com.billionairestore.inventoryservice.command.rest;

import lombok.Data;

@Data
public class DeleteInventoryRestModel {
    private final String productId;
    private final int quantity;
}
