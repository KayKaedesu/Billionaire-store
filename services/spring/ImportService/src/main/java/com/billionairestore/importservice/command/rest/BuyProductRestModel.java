package com.billionairestore.importservice.command.rest;

import lombok.Data;

@Data
public class BuyProductRestModel {
    private String productId;
    private String userId;
    private String name;
    private String category;
    private Double buyPrice;
    private Double quantity;
}
