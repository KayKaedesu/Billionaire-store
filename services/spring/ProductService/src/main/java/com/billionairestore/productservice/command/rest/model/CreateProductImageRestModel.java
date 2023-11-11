package com.billionairestore.productservice.command.rest.model;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class CreateProductImageRestModel {
    private String productId;
    private MultipartFile file;
}
