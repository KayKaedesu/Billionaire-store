package com.billionairestore.productservice.command.rest;

import com.billionairestore.productservice.command.commands.CreateProductCommand;
import com.billionairestore.productservice.command.rest.model.CreateProductRestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductRestController {

    CommandGateway commandGateway;

    @Autowired
    public ProductRestController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }
    @PostMapping
    public void createProduct(@RequestBody CreateProductRestModel createProductRestModel) {
        CreateProductCommand command = CreateProductCommand.builder()
                .name(createProductRestModel.getName())
                .category(createProductRestModel.getCategory())
                .imageUrl(createProductRestModel.getImageUrl())
                .productId(createProductRestModel.getProductId())
                .buyPrice(createProductRestModel.getBuyPrice())
                .sellPrice(createProductRestModel.getSellPrice())
                .build();
        commandGateway.sendAndWait(command);
    }

}
