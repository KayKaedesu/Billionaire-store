package com.billionairestore.importservice.command;

import com.billionairestore.core.events.BuyProductCreatedEvent;
import com.billionairestore.importservice.command.commands.BuyProductCommand;
import com.billionairestore.importservice.command.commands.CreateImportCommand;
import com.billionairestore.importservice.core.events.ImportCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class ImportAggregate {
    @AggregateIdentifier
    private String productId;
    private String name;
    private String category;
    private Double buyPrice;

    public ImportAggregate() {
    }

    @CommandHandler
    public ImportAggregate(CreateImportCommand command) {
        ImportCreatedEvent event = new ImportCreatedEvent();
        BeanUtils.copyProperties(command, event);
        AggregateLifecycle.apply(event);
    }

//    @CommandHandler
//    public ImportAggregate(BuyProductCommand command) {
//        BuyProductCreatedEvent event = BuyProductCreatedEvent.builder()
//                .aggregateId(command.getAggregateId())
//                .productId(command.getProductId())
//                .userId(command.getUserId())
//                .name(command.getName())
//                .category(command.getCategory())
//                .buyPrice(command.getBuyPrice())
//                .quantity(command.getQuantity())
//                .build();
////        BeanUtils.copyProperties(command, event);
//        AggregateLifecycle.apply(event);
//    }

    @EventSourcingHandler
    public void on(ImportCreatedEvent event) {
        System.out.println("aggregating import");
        this.productId = event.getProductId();
        this.name = event.getName();
        this.category = event.getCategory();
        this.buyPrice = event.getBuyPrice();
    }
}
