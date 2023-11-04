package com.billionairestore.productservice.command.rest.model;

import lombok.Data;

@Data
public class CreateProductRestModel {
    private String productId;
    private String name;
    private String imageUrl;
    private String category;
    private Double buyPrice;
    private Double sellPrice;
}
