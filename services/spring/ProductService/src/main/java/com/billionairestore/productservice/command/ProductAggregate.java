package com.billionairestore.productservice.command;

import com.billionairestore.productservice.command.commands.CreateProductCommand;
import com.billionairestore.productservice.command.commands.DeleteProductCommand;
import com.billionairestore.productservice.command.commands.PutProductCommand;
import com.billionairestore.productservice.core.events.ProductDeletedEvent;
import com.billionairestore.productservice.core.events.ProductCreatedEvent;
import com.billionairestore.productservice.core.events.ProductPutEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class ProductAggregate {
    @AggregateIdentifier
    private String aggregateId;
    private String productId;
    private String name;
    private String imageUrl;
    private String category;
    private Double buyPrice;
    private Double sellPrice;

    @CommandHandler
    public ProductAggregate() {
    }

    @CommandHandler
    public ProductAggregate(CreateProductCommand createProductCommand) {
        ProductCreatedEvent event = new ProductCreatedEvent();
        BeanUtils.copyProperties(createProductCommand, event);
        AggregateLifecycle.apply(event);
    }


    @CommandHandler
    public ProductAggregate(DeleteProductCommand command) {
        ProductDeletedEvent event = new ProductDeletedEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @CommandHandler
    public ProductAggregate(PutProductCommand command) {
        ProductPutEvent event = new ProductPutEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(ProductDeletedEvent event) {
        System.out.println("aggregating product");
        this.aggregateId = event.getAggregateId();
        this.productId = event.getProductId();
    }
    @EventSourcingHandler
    public void on(ProductCreatedEvent event) {
        System.out.println("aggregating product");
        this.aggregateId = event.getAggregateId();
        this.productId = event.getProductId();
        this.name = event.getName();
        this.imageUrl = event.getImageUrl();
        this.category = event.getCategory();
        this.buyPrice = event.getBuyPrice();
        this.sellPrice = event.getSellPrice();
    }

    @EventSourcingHandler
    public void on(ProductPutEvent event) {
        System.out.println("aggregating product");
        this.aggregateId = event.getAggregateId();
        this.productId = event.getProductId();
        this.name = event.getName();
        this.imageUrl = event.getImageUrl();
        this.category = event.getCategory();
        this.buyPrice = event.getBuyPrice();
        this.sellPrice = event.getSellPrice();
    }

}
