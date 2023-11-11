package com.billionairestore.posservice.command;

import com.billionairestore.posservice.command.create.CreatePOSCommand;
import com.billionairestore.posservice.command.create.DeletePOSCommand;
import com.billionairestore.posservice.command.create.UpdatePOSCommand;
import com.billionairestore.posservice.core.events.POSCreatedEvent;
import com.billionairestore.posservice.core.events.POSDeletedEvent;
import com.billionairestore.posservice.core.events.POSUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class POSAggregate {
    @AggregateIdentifier
    private String aggregateId;
    private String POSId;
    private String employeeId;
    private String productId;
    private String sellPrice;
    private String quantity;

    public POSAggregate(){}
    @CommandHandler
    public POSAggregate(CreatePOSCommand createPOSCommand){
        if (createPOSCommand.getEmployeeId().isBlank() || createPOSCommand.getProductId().isBlank() || createPOSCommand.getSellPrice().isBlank() || createPOSCommand.getQuantity().isBlank()){
            throw new IllegalArgumentException("กรอกให้ครบ");
        }
        POSCreatedEvent posCreatedEvent = new POSCreatedEvent();
        BeanUtils.copyProperties(createPOSCommand, posCreatedEvent);
        AggregateLifecycle.apply(posCreatedEvent);
    }

    @CommandHandler
    public POSAggregate(DeletePOSCommand deletePOSCommand){
        if (deletePOSCommand.getPOSId().isBlank()){
            throw new IllegalArgumentException("err");
        }
        POSDeletedEvent posDeletedEvent = new POSDeletedEvent();
        BeanUtils.copyProperties(deletePOSCommand, posDeletedEvent);
        AggregateLifecycle.apply(posDeletedEvent);
    }

    @CommandHandler
    public POSAggregate(UpdatePOSCommand updatePOSCommand){
        if (updatePOSCommand.getEmployeeId().isBlank() || updatePOSCommand.getProductId().isBlank() || updatePOSCommand.getSellPrice().isBlank() || updatePOSCommand.getQuantity().isBlank()){
            throw new IllegalArgumentException("กรอกให้ครบด้วย");
        }
        POSUpdatedEvent posUpdatedEvent = new POSUpdatedEvent();
        BeanUtils.copyProperties(updatePOSCommand, posUpdatedEvent);
        AggregateLifecycle.apply(posUpdatedEvent);
    }

    @EventSourcingHandler
    public void on(POSCreatedEvent posCreatedEvent) {
        System.out.println("ON AGGREGATE " + posCreatedEvent);
        this.aggregateId = posCreatedEvent.getAggregateId();
        this.POSId = posCreatedEvent.getPOSId();
        this.employeeId = posCreatedEvent.getEmployeeId();
        this.productId = posCreatedEvent.getProductId();
        this.sellPrice = posCreatedEvent.getSellPrice();
        this.quantity = posCreatedEvent.getQuantity();
    }

    @EventSourcingHandler
    public void on(POSDeletedEvent posDeletedEvent) {
        System.out.println("ON AGGREGATE " + posDeletedEvent);
        this.aggregateId = posDeletedEvent.getAggregateId();
        this.POSId = posDeletedEvent.getPOSId();
        this.employeeId = posDeletedEvent.getEmployeeId();
        this.productId = posDeletedEvent.getProductId();
        this.sellPrice = posDeletedEvent.getSellPrice();
        this.quantity = posDeletedEvent.getQuantity();
    }

    @EventSourcingHandler
    public void on(POSUpdatedEvent posUpdatedEvent) {
        System.out.println("ON AGGREGATE " + posUpdatedEvent);
        this.aggregateId = posUpdatedEvent.getAggregateId();
        this.POSId = posUpdatedEvent.getPOSId();
        this.employeeId = posUpdatedEvent.getEmployeeId();
        this.productId = posUpdatedEvent.getProductId();
        this.sellPrice = posUpdatedEvent.getSellPrice();
        this.quantity = posUpdatedEvent.getQuantity();
    }
}
