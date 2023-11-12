package com.billionairestore.productservice.command.rest.model;

import lombok.Data;

@Data
public class CreateProductRestModel {
    private String name;
    private String category;
    private Double sellPrice;
}
