package com.billionairestore.importservice.command.rest.model;

import lombok.Data;

@Data
public class CreateImportRestModel {
    private String importId;
    private String productId;
    private String name;
    private String category;
    private Double buyPrice;
}
