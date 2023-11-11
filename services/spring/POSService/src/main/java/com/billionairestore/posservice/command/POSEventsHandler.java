package com.billionairestore.posservice.command;

import com.billionairestore.posservice.core.events.POSCreatedEvent;
import com.billionairestore.posservice.core.events.POSDeletedEvent;
import com.billionairestore.posservice.core.events.POSUpdatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class POSEventsHandler {
    @EventHandler
    public void on(POSCreatedEvent event){
        System.out.println("created");
    }

    @EventHandler
    public void on(POSDeletedEvent event){
        System.out.println("deleted");
    }

    @EventHandler
    public void on(POSUpdatedEvent event){
        System.out.println("updated");
    }
}
