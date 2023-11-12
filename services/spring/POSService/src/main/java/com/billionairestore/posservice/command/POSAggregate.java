package com.billionairestore.posservice.command;

import com.billionairestore.core.events.POSCreatedEvent;
import com.billionairestore.posservice.command.create.CreatePOSCommand;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Array;

@Aggregate
public class POSAggregate {
    @AggregateIdentifier
    private String aggregateId;
    private String POSId;
    private String userId;
    private Array productList;


    public POSAggregate(){}
    @CommandHandler
    public POSAggregate(CreatePOSCommand createPOSCommand){
        POSCreatedEvent event =  POSCreatedEvent.builder()
                .aggregateId(createPOSCommand.getAggregateId())
                .POSId(createPOSCommand.getPOSId())
                .userId(createPOSCommand.getUserId())
                .productList(createPOSCommand.getProductList())
                .build();
        AggregateLifecycle.apply(event);
        System.out.println("command POS");
    }

    @EventSourcingHandler
    public void on(POSCreatedEvent posCreatedEvent) {
        System.out.println("ON AGGREGATE " + posCreatedEvent);
        this.aggregateId = posCreatedEvent.getAggregateId();
        this.POSId = posCreatedEvent.getPOSId();
        this.userId = posCreatedEvent.getUserId();
        this.productList = posCreatedEvent.getProductList();
    }

}
