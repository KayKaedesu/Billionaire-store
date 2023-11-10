package com.billionairestore.inventoryservice.command.commands;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReduceInventoryCommand {
    private String productId;
    private int quantity;
}
