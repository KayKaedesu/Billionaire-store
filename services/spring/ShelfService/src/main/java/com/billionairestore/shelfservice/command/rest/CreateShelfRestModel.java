package com.billionairestore.shelfservice.command.rest;

import lombok.Data;

@Data
public class CreateShelfRestModel {
    private final String productId;
    private final String amount;
}
