package com.billionairestore.productservice.command.rest;

import com.billionairestore.productservice.command.commands.CreateProductCommand;
import com.billionairestore.productservice.command.commands.CreateProductImageCommand;
import com.billionairestore.productservice.command.commands.DeleteProductCommand;
import com.billionairestore.productservice.command.commands.PutProductCommand;
import com.billionairestore.productservice.command.rest.model.CreateProductImageRestModel;
import com.billionairestore.productservice.command.rest.model.CreateProductRestModel;
import com.billionairestore.productservice.command.rest.model.DeleteProductRestModel;
import com.billionairestore.productservice.command.rest.model.PutProductRestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.client.WebClient;

import java.io.File;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductRestController {
    CommandGateway commandGateway;

    @Autowired
    public ProductRestController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @DeleteMapping
    public String deleteProduct(@RequestBody DeleteProductRestModel deleteProductRestModel) {
        DeleteProductCommand deleteProductCommand = DeleteProductCommand.builder()
                .aggregateId(UUID.randomUUID().toString())
                .productId(deleteProductRestModel.getProductId())
                .build();
        String result;
        try {
            commandGateway.sendAndWait(deleteProductCommand);
            result = "deleted successfully";
        } catch (Exception e) {
            result = "error deleting product";
        }
        return result;
    }
    @PostMapping
    public String createProduct(@RequestBody CreateProductRestModel createProductRestModel) {
        CreateProductCommand createProductCommand = CreateProductCommand.builder()
                .aggregateId(UUID.randomUUID().toString())
                .name(createProductRestModel.getName())
                .category(createProductRestModel.getCategory())
                .sellPrice(createProductRestModel.getSellPrice())
                .productId(UUID.randomUUID().toString())
                .aggregateId(UUID.randomUUID().toString())
                .build();
        String result;
        try {
            commandGateway.sendAndWait(createProductCommand);
            result = "created successfully";
        } catch (Exception e) {
            result = "error creating product";
        }
        return result;
    }

    @PutMapping
    public String putProduct(@RequestBody PutProductRestModel putProductRestModel) {
        PutProductCommand putProductCommand = PutProductCommand.builder()
                .aggregateId(UUID.randomUUID().toString())
                .productId(putProductRestModel.getProductId())
                .name(putProductRestModel.getName())
                .category(putProductRestModel.getCategory())
                .sellPrice(putProductRestModel.getSellPrice())
                .build();
        String result;
        try {
            commandGateway.sendAndWait(putProductCommand);
            result = "updated successfully";
        } catch (Exception e) {
            result = "error updating product";
        }
        return result;
    }

    @PostMapping("/image")
    public String imageUpload(@ModelAttribute CreateProductImageRestModel model) {
        CreateProductImageCommand createProductImageCommand = CreateProductImageCommand.builder()
                .aggregateId(UUID.randomUUID().toString())
                .productId(model.getProductId())
                .file(model.getFile())
                .build();
        String result;
        try {
            commandGateway.sendAndWait(createProductImageCommand);
            result = "uploaded successfully";
        } catch(Exception e) {
            result = "error uploading image";
        }
        return result;
    }



}
