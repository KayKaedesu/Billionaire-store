package com.billionairestore.inventoryservice.command;

import com.billionairestore.inventoryservice.command.commands.CreateProductInventoryCommand;
import com.billionairestore.inventoryservice.command.commands.DeleteProductInventoryCommand;
import com.billionairestore.inventoryservice.core.events.InventoryProductCreatedEvent;
import com.billionairestore.inventoryservice.core.events.InventoryProductDeletedEvent;
import com.billionairestore.productservice.command.commands.CreateProductCommand;
import com.billionairestore.productservice.core.events.ProductCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class InventoryAggregate {
    @TargetAggregateIdentifier
    private String productId;

    @CommandHandler
    public InventoryAggregate(CreateProductInventoryCommand command) {
        InventoryProductCreatedEvent event = new InventoryProductCreatedEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(InventoryProductCreatedEvent event) {
        this.productId = event.getProductId();
    }


    @CommandHandler
    public InventoryAggregate(DeleteProductInventoryCommand command) {
        InventoryProductDeletedEvent event = new InventoryProductDeletedEvent(command.getProductId());
        AggregateLifecycle.apply(event);
    }

    @EventSourcingHandler
    public void on(InventoryProductDeletedEvent event) {
        this.productId = event.getProductId();
    }

}
