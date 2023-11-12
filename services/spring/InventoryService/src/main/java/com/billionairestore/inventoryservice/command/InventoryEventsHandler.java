package com.billionairestore.inventoryservice.command;

import com.billionairestore.core.events.BuyProductCreatedEvent;
import com.billionairestore.core.events.CreatedEvent;
import com.billionairestore.inventoryservice.core.data.InventoryEntity;
import com.billionairestore.inventoryservice.core.data.InventoryRepository;
import com.billionairestore.inventoryservice.core.events.InventoryCreatedEvent;
import com.billionairestore.inventoryservice.core.events.InventoryDeletedEvent;
import com.billionairestore.inventoryservice.query.FindInventoryQuery;
import com.billionairestore.inventoryservice.query.rest.InventoryRestModel;
import com.billionairestore.productservice.core.data.ProductEntity;
import com.billionairestore.productservice.core.events.ProductCreatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InventoryEventsHandler {

    private final InventoryRepository inventoryRepository;
    public InventoryEventsHandler(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }


    @EventHandler
    public void on(InventoryCreatedEvent event){
        System.out.println("created");
        InventoryEntity inventoryEntity = new InventoryEntity();
        BeanUtils.copyProperties(event, inventoryEntity);
        inventoryRepository.save(inventoryEntity);
    }
    @EventHandler
    public void on(CreatedEvent event){
        System.out.println("created from product");
        InventoryEntity inventoryEntity = new InventoryEntity();
        inventoryEntity.setProductId(event.getProductId());
        inventoryEntity.setQuantity(0);
        inventoryRepository.save(inventoryEntity);
    }

    @EventHandler
    public void on(BuyProductCreatedEvent event){
        System.out.println("buy");
        InventoryEntity inventoryEntity = inventoryRepository.findByProductId(event.getProductId());
        inventoryEntity.setQuantity(inventoryEntity.getQuantity()+event.getQuantity());
        System.out.println(inventoryEntity);
        inventoryRepository.save(inventoryEntity);
    }


    @EventHandler
    public void on(InventoryDeletedEvent event){
        System.out.println("deleted");
        InventoryEntity inventoryEntity = new InventoryEntity();
        BeanUtils.copyProperties(event, inventoryEntity);
        inventoryRepository.delete(inventoryEntity);
    }

}
