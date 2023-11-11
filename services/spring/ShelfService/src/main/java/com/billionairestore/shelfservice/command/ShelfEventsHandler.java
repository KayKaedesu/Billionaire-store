package com.billionairestore.shelfservice.command;

import com.billionairestore.core.events.CreatedEvent;
import com.billionairestore.shelfservice.core.data.ShelfEntity;
import com.billionairestore.shelfservice.core.data.ShelfRepository;
import com.billionairestore.shelfservice.core.events.ShelfCreatedEvent;
import com.billionairestore.shelfservice.core.events.ShelfDeletedEvent;
import com.billionairestore.shelfservice.core.events.ShelfUpdatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class ShelfEventsHandler {
    private final ShelfRepository shelfRepository;
    public ShelfEventsHandler(ShelfRepository shelfRepository){
        this.shelfRepository = shelfRepository;
    }
    @EventHandler
    public void on(ShelfCreatedEvent event){
        System.out.println("created");
        ShelfEntity shelfEntity = new ShelfEntity();
        BeanUtils.copyProperties(event, shelfEntity);
        shelfRepository.save(shelfEntity);
    }

    @EventHandler
    public void on(CreatedEvent event){
        System.out.println("created from product");
        ShelfEntity shelfEntity = new ShelfEntity();
        shelfEntity.setProductId(event.getProductId());
        shelfEntity.setQuantity(0);
        shelfRepository.save(shelfEntity);
    }


    @EventHandler
    public void on(ShelfDeletedEvent event){
        System.out.println("deleted");
        ShelfEntity shelfEntity = new ShelfEntity();
        BeanUtils.copyProperties(event, shelfEntity);
        shelfRepository.delete(shelfEntity);
    }

    @EventHandler
    public void on(ShelfUpdatedEvent event){
        System.out.println("updated");
        ShelfEntity shelfEntity = new ShelfEntity();
        BeanUtils.copyProperties(event, shelfEntity);
        shelfRepository.save(shelfEntity);
    }
}
