package com.billionairestore.shelfservice.command;

import com.billionairestore.shelfservice.command.commands.CreateShelfCommand;
import com.billionairestore.shelfservice.command.commands.DeleteShelfCommand;
import com.billionairestore.shelfservice.command.commands.UpdateShelfCommand;
import com.billionairestore.shelfservice.core.events.ShelfCreatedEvent;
import com.billionairestore.shelfservice.core.events.ShelfDeletedEvent;
import com.billionairestore.shelfservice.core.events.ShelfUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class ShelfAggregate {
    @AggregateIdentifier
    private String aggregateId;
//    private String shelfId;
    private String productId;
    private int quantity;

    public ShelfAggregate(){}
    @CommandHandler
    public ShelfAggregate(CreateShelfCommand createShelfCommand){
        if (createShelfCommand.getProductId().isBlank()){
            throw new IllegalArgumentException("กรอกให้ครบ");
        }
        ShelfCreatedEvent shelfCreatedEvent = new ShelfCreatedEvent();
        BeanUtils.copyProperties(createShelfCommand, shelfCreatedEvent);
        AggregateLifecycle.apply(shelfCreatedEvent);
    }

    @CommandHandler
    public ShelfAggregate(DeleteShelfCommand deleteShelfCommand){
        if (deleteShelfCommand.getProductId().isBlank()){
            throw new IllegalArgumentException("err");
        }
        ShelfDeletedEvent shelfDeletedEvent = new ShelfDeletedEvent();
        BeanUtils.copyProperties(deleteShelfCommand, shelfDeletedEvent);
        AggregateLifecycle.apply(shelfDeletedEvent);
    }

    @CommandHandler
    public ShelfAggregate(UpdateShelfCommand updateShelfCommand){
        if (updateShelfCommand.getProductId().isBlank()){
            throw new IllegalArgumentException("กรอกให้ครบด้วย");
        }
        ShelfUpdatedEvent shelfUpdatedEvent = new ShelfUpdatedEvent();
        BeanUtils.copyProperties(updateShelfCommand, shelfUpdatedEvent);
        AggregateLifecycle.apply(shelfUpdatedEvent);
    }

    @EventSourcingHandler
    public void on(ShelfCreatedEvent shelfCreatedEvent) {
        System.out.println("ON AGGREGATE " + shelfCreatedEvent);
        this.aggregateId = shelfCreatedEvent.getAggregateId();
//        this.shelfId = shelfCreatedEvent.getShelfId();
        this.productId = shelfCreatedEvent.getProductId();
        this.quantity = shelfCreatedEvent.getQuantity();
    }

    @EventSourcingHandler
    public void on(ShelfDeletedEvent shelfDeletedEvent) {
        System.out.println("ON AGGREGATE " + shelfDeletedEvent);
        this.aggregateId = shelfDeletedEvent.getAggregateId();
//        this.shelfId= shelfDeletedEvent.getShelfId();
        this.productId = shelfDeletedEvent.getProductId();
        this.quantity = shelfDeletedEvent.getQuantity();
    }

    @EventSourcingHandler
    public void on(ShelfUpdatedEvent shelfUpdatedEvent) {
        System.out.println("ON AGGREGATE " + shelfUpdatedEvent);
        this.aggregateId = shelfUpdatedEvent.getAggregateId();
//        this.shelfId= shelfUpdatedEvent.getShelfId();
        this.productId = shelfUpdatedEvent.getProductId();
        this.quantity = shelfUpdatedEvent.getQuantity();
    }
}
