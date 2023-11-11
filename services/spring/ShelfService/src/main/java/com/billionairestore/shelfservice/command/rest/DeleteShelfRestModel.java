package com.billionairestore.shelfservice.command.rest;

import lombok.Data;

@Data
public class DeleteShelfRestModel {
    private final String productId;
    private final String amount;
}
