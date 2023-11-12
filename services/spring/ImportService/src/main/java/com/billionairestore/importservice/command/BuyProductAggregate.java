package com.billionairestore.importservice.command;

import com.billionairestore.core.events.BuyProductCreatedEvent;
import com.billionairestore.importservice.command.commands.BuyProductCommand;
import com.billionairestore.importservice.core.events.ImportCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
public class BuyProductAggregate {
    @AggregateIdentifier
    private String aggregateId;
    private String logId;
    private String productId;
    private String userId;
    private String name;
    private String category;
    private Double buyPrice;
    private int quantity;

    public BuyProductAggregate(){

    }
    @CommandHandler
    public BuyProductAggregate(BuyProductCommand command) {
        BuyProductCreatedEvent event = BuyProductCreatedEvent.builder()
                .logId(command.getLogId())
                .aggregateId(command.getAggregateId())
                .productId(command.getProductId())
                .userId(command.getUserId())
                .name(command.getName())
                .category(command.getCategory())
                .buyPrice(command.getBuyPrice())
                .quantity(command.getQuantity())
                .build();
//        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
        System.out.println("command buy");
    }

    @EventSourcingHandler
    public void on(BuyProductCreatedEvent event) {
        System.out.println("aggregating buy");
        this.aggregateId = event.getAggregateId();
        this.logId = event.getLogId();
        this.productId = event.getProductId();
        this.userId = event.getUserId();
        this.name = event.getName();
        this.category = event.getCategory();
        this.buyPrice = event.getBuyPrice();
        this.quantity = event.getQuantity();
    }
}
