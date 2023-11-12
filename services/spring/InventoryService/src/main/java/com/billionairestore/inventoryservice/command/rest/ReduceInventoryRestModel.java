package com.billionairestore.inventoryservice.command.rest;

import lombok.Data;

@Data
public class ReduceInventoryRestModel
{
    private final String productId;
    private final int quantity;
}
