package com.billionairestore.inventoryservice.command.commands;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IncreaseInventoryCommand {
    private String productId;
    private int quantity;
}
