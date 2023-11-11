package com.billionairestore.productservice.command.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
public class CreateProductImageCommand {
    @TargetAggregateIdentifier
    private String aggregateId;
    private String productId;
    private MultipartFile file;
}
