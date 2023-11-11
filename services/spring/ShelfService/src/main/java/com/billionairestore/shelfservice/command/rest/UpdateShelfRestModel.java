package com.billionairestore.shelfservice.command.rest;

import lombok.Data;

@Data
public class UpdateShelfRestModel {
//    private final String shelfId;
    private final String productId;
    private final int quantity;
}
