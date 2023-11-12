package com.billionairestore.productservice.command;

import com.billionairestore.productservice.command.commands.CreateProductImageCommand;
import com.billionairestore.productservice.core.data.ProductRepository;
import com.billionairestore.productservice.core.events.ProductImageCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

public class ProductImageAggregate {
    @AggregateIdentifier
    private String aggregateId;
    private String productId;
    private String imageUrl;


    private WebClient webClient = WebClient.create("http://localhost:3000/");

    @CommandHandler
    public ProductImageAggregate() {
    }

    @CommandHandler
    public ProductImageAggregate(CreateProductImageCommand command) {
        MultipartFile file = command.getFile();

        MultipartBodyBuilder builder = new MultipartBodyBuilder();
        builder.part("file", file.getResource());
        builder.part("path", "product-images");

        // comes with no / at start
        String path = webClient.post()
                .uri("/upload")
                .body(BodyInserters.fromMultipartData(builder.build()))
                .retrieve()
                .bodyToMono(String.class)
                .block();

        String pathWithSlash = "/" + path;


        ProductImageCreatedEvent event = new ProductImageCreatedEvent(command.getAggregateId(), command.getProductId(), pathWithSlash);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ProductImageCreatedEvent event) {
        System.out.println("aggregating product");
        this.aggregateId = event.getAggregateId();
        this.productId = event.getProductId();
        this.imageUrl = event.getImagePath();
    }
}
