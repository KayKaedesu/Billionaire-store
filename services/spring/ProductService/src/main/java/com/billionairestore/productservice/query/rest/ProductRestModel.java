package com.billionairestore.productservice.query.rest;

import lombok.Data;

@Data
public class ProductRestModel {
    private String productId;
    private String name;
    private String category;
    private Double sellPrice;
    private String imageUrl;
}
