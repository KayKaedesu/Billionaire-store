package com.billionairestore.inventoryservice.command.commands;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
public class CreateProductInventoryCommand {
    private String productId;
}
