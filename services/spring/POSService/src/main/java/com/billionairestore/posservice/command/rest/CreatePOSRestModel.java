package com.billionairestore.posservice.command.rest;

import lombok.Data;

@Data
public class CreatePOSRestModel {
    private final String POSId;
    private final String employeeId;
    private final String productId;
    private final String sellPrice;
    private final String quantity;
}
