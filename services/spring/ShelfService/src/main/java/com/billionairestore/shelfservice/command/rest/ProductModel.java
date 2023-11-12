package com.billionairestore.shelfservice.command.rest;

import lombok.Data;

@Data
public class ProductModel {
    private String productId;
    private Double quantity;
    private Double sellPrice;
}
