package com.billionairestore.shelfservice.command;

import com.billionairestore.shelfservice.command.create.CreateShelfCommand;
import com.billionairestore.shelfservice.command.create.DeleteShelfCommand;
import com.billionairestore.shelfservice.command.create.UpdateShelfCommand;
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
    private String productId;
    private String amount;

    public ShelfAggregate(){}
    @CommandHandler
    public ShelfAggregate(CreateShelfCommand createShelfCommand){
        if (createShelfCommand.getProductId().isBlank() || createShelfCommand.getAmount().isBlank()){
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
        if (updateShelfCommand.getProductId().isBlank() || updateShelfCommand.getAmount().isBlank()){
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
        this.productId = shelfCreatedEvent.getProductId();
        this.amount = shelfCreatedEvent.getAmount();
    }

    @EventSourcingHandler
    public void on(ShelfDeletedEvent shelfDeletedEvent) {
        System.out.println("ON AGGREGATE " + shelfDeletedEvent);
        this.aggregateId = shelfDeletedEvent.getAggregateId();
        this.productId = shelfDeletedEvent.getProductId();
        this.amount = shelfDeletedEvent.getAmount();
    }

    @EventSourcingHandler
    public void on(ShelfUpdatedEvent shelfUpdatedEvent) {
        System.out.println("ON AGGREGATE " + shelfUpdatedEvent);
        this.aggregateId = shelfUpdatedEvent.getAggregateId();
        this.productId = shelfUpdatedEvent.getProductId();
        this.amount = shelfUpdatedEvent.getAmount();
    }
}
