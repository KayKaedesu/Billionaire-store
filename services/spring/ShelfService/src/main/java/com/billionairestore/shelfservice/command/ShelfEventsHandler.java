package com.billionairestore.shelfservice.command;

import com.billionairestore.core.events.CreatedEvent;
import com.billionairestore.core.events.InventoryToShelfEvent;
import com.billionairestore.core.events.POSCreatedEvent;
import com.billionairestore.core.events.ShelfToInventoryEvent;
import com.billionairestore.shelfservice.command.rest.ProductModel;
import com.billionairestore.shelfservice.core.data.InventoryEntity;
import com.billionairestore.shelfservice.core.data.InventoryRepository;
import com.billionairestore.shelfservice.core.data.ShelfEntity;
import com.billionairestore.shelfservice.core.data.ShelfRepository;
import com.billionairestore.shelfservice.core.events.ShelfCreatedEvent;
import com.billionairestore.shelfservice.core.events.ShelfDeletedEvent;
import com.billionairestore.shelfservice.core.events.ShelfUpdatedEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ShelfEventsHandler {
    private static ShelfRepository shelfRepository;
    private static InventoryRepository inventoryRepository;

    public ShelfEventsHandler(ShelfRepository shelfRepository, InventoryRepository inventoryRepository) {
        this.shelfRepository = shelfRepository;
        this.inventoryRepository = inventoryRepository;
    }

    @EventHandler
    public void on(ShelfCreatedEvent event) {
        System.out.println("created");
        ShelfEntity shelfEntity = new ShelfEntity();
        BeanUtils.copyProperties(event, shelfEntity);
        shelfRepository.save(shelfEntity);
    }

    @EventHandler
    public void on(CreatedEvent event) {
        System.out.println("created from product");
        ShelfEntity shelfEntity = new ShelfEntity();
        shelfEntity.setProductId(event.getProductId());
        shelfEntity.setQuantity(0);
        shelfRepository.save(shelfEntity);
    }


    @EventHandler
    public void on(ShelfDeletedEvent event) {
        System.out.println("deleted");
        ShelfEntity shelfEntity = new ShelfEntity();
        BeanUtils.copyProperties(event, shelfEntity);
        shelfRepository.delete(shelfEntity);
    }

    @EventHandler
    public void on(ShelfUpdatedEvent event) {
        System.out.println("updated");
        ShelfEntity shelfEntity = new ShelfEntity();
        BeanUtils.copyProperties(event, shelfEntity);
        shelfRepository.save(shelfEntity);
    }

    @EventHandler
    public void on(InventoryToShelfEvent event) {
        InventoryEntity inventoryEntity = inventoryRepository.findByProductId(event.getProductId());
        if (inventoryEntity == null || inventoryEntity.getQuantity() < event.getQuantity()) {
            // กรณีของ inventory น้อยกว่าที่เพิ่มลงมา
            throw new IllegalArgumentException("Inventory quantity is less than the added quantity");
        } else {
            inventoryEntity.setQuantity(inventoryEntity.getQuantity() - event.getQuantity());
            System.out.println(inventoryEntity);
            inventoryRepository.save(inventoryEntity);
        }
        ShelfEntity shelfEntity = shelfRepository.findByProductId(event.getProductId());
        System.out.println("to shelf");
        shelfEntity.setQuantity(shelfEntity.getQuantity() + event.getQuantity());
        System.out.println(shelfEntity);
        shelfRepository.save(shelfEntity);
    }

    @EventHandler
    public void on(ShelfToInventoryEvent event) {
        ShelfEntity shelfEntity = shelfRepository.findByProductId(event.getProductId());
        System.out.println(shelfEntity);
        if (shelfEntity == null || shelfEntity.getQuantity() < event.getQuantity()) {
            // กรณีของ shelf น้อยกว่าที่เพิ่มลงมา
            throw new IllegalArgumentException("Shelf quantity is less than the added quantity");
        } else {
            shelfEntity.setQuantity(shelfEntity.getQuantity() - event.getQuantity());
            System.out.println(shelfEntity);
            shelfRepository.save(shelfEntity);
        }
        InventoryEntity inventoryEntity = inventoryRepository.findByProductId(event.getProductId());
        System.out.println("to inventory");
        inventoryEntity.setQuantity(inventoryEntity.getQuantity() + event.getQuantity());
        inventoryRepository.save(inventoryEntity);
    }

    @EventHandler
    public static void on(POSCreatedEvent event) {
        for (Object object : event.getProductList()) {
            ObjectMapper objectMapper = new ObjectMapper();
            ProductModel productModel = objectMapper.convertValue(object, ProductModel.class);
            ShelfEntity shelfEntity = shelfRepository.findByProductId(productModel.getProductId());
            if (shelfEntity == null || shelfEntity.getQuantity() < productModel.getQuantity()) {
                // กรณีของ shelf น้อยกว่าที่เพิ่มลงมา
                throw new IllegalArgumentException("Shelf quantity is less than the added quantity");
            } else {
                shelfEntity.setQuantity(shelfEntity.getQuantity() - productModel.getQuantity().intValue());
                shelfRepository.save(shelfEntity);
            }
        }
    }
}
