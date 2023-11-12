package com.billionairestore.inventoryservice.command;

import com.billionairestore.core.events.CreatedEvent;
import com.billionairestore.inventoryservice.core.data.InventoryEntity;
import com.billionairestore.inventoryservice.core.data.InventoryRepository;
import com.billionairestore.inventoryservice.core.events.InventoryCreatedEvent;
import com.billionairestore.inventoryservice.core.events.InventoryDeletedEvent;


import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

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
    public void on(InventoryDeletedEvent event){
        System.out.println("deleted");
        InventoryEntity inventoryEntity = new InventoryEntity();
        BeanUtils.copyProperties(event, inventoryEntity);
        inventoryRepository.delete(inventoryEntity);
    }
}
