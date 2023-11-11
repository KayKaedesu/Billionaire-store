package com.billionairestore.importservice.command.rest;

import lombok.Data;

@Data
public class CreateImportRestModel {
    private String productId;
    private String name;
    private String category;
    private Double buyPrice;
}
