package com.billionairestore.inventoryservice.command.rest;

import lombok.Data;

@Data
public class CreateInventoryRestModel {
    private final String productId;
    private final int quantity;
}
