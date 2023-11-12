package com.billionairestore.inventoryservice.command;

import com.billionairestore.inventoryservice.command.commands.CreateInventoryCommand;
import com.billionairestore.inventoryservice.command.commands.DeleteInventoryCommand;
import com.billionairestore.inventoryservice.core.events.InventoryCreatedEvent;
import com.billionairestore.inventoryservice.core.events.InventoryDeletedEvent;
import com.billionairestore.productservice.command.commands.CreateProductCommand;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

@Aggregate
public class InventoryAggregate {
    @AggregateIdentifier
    private String aggregateId;
    private String productId;
    private int quantity;

    public InventoryAggregate(){}


    @CommandHandler
    public InventoryAggregate(CreateInventoryCommand createInventoryCommand){
        if (createInventoryCommand.getProductId().isBlank()){
            throw new IllegalArgumentException("กรอกให้ครบ");
        }
        InventoryCreatedEvent inventoryCreatedEvent = new InventoryCreatedEvent();
        BeanUtils.copyProperties(createInventoryCommand, inventoryCreatedEvent);
        AggregateLifecycle.apply(inventoryCreatedEvent);
    }

    @CommandHandler
    public InventoryAggregate(DeleteInventoryCommand deleteInventoryCommand){
        if (deleteInventoryCommand.getProductId().isBlank()){
            throw new IllegalArgumentException("err");
        }
        InventoryDeletedEvent inventoryDeletedEvent = new InventoryDeletedEvent();
        BeanUtils.copyProperties(deleteInventoryCommand, inventoryDeletedEvent);
        AggregateLifecycle.apply(inventoryDeletedEvent);
    }



    @EventSourcingHandler
    public void on(InventoryCreatedEvent inventoryCreatedEvent) {
        System.out.println("ON AGGREGATE " + inventoryCreatedEvent);
        this.aggregateId = inventoryCreatedEvent.getAggregateId();
        this.productId = inventoryCreatedEvent.getProductId();
        this.quantity = inventoryCreatedEvent.getQuantity();
    }

    @EventSourcingHandler
    public void on(InventoryDeletedEvent inventoryDeletedEvent) {
        System.out.println("ON AGGREGATE " + inventoryDeletedEvent);
        this.aggregateId = inventoryDeletedEvent.getAggregateId();
        this.productId = inventoryDeletedEvent.getProductId();
        this.quantity = inventoryDeletedEvent.getQuantity();
    }

}
