package com.billionairestore.inventoryservice.command.commands;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class DeleteProductInventoryCommand {
    private String productId;
}
