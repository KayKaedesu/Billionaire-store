package com.billionairestore.importservice.query.rest;

import lombok.Data;

@Data
public class ImportRestModel {
    private String importId;
    private String productId;
    private String name;
    private String category;
    private Double buyPrice;
}
