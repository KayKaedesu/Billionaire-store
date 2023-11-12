package com.billionairestore.logservice.commands;

import com.billionairestore.core.events.BuyProductCreatedEvent;
import com.billionairestore.core.events.CreatedEvent;
import com.billionairestore.logservice.core.data.ImportLogEntity;
import com.billionairestore.logservice.core.data.ImportLogRepository;
import com.google.type.DateTime;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;

@Component
public class LogEventsHandler {
    private final ImportLogRepository importLogRepository;
    public LogEventsHandler(ImportLogRepository importLogRepository){
        this.importLogRepository = importLogRepository;
    }
    @EventHandler
    public void on(BuyProductCreatedEvent event){
        System.out.println("created from buy");
        ImportLogEntity importLogEntity = new ImportLogEntity();
        importLogEntity.setUserId(event.getUserId());
        importLogEntity.setLogId(event.getLogId());
        importLogEntity.setProductId(event.getProductId());
        importLogEntity.setName(event.getName());
        importLogEntity.setCategory(event.getCategory());
        importLogEntity.setBuyPrice(event.getBuyPrice());
        importLogEntity.setQuantity(event.getQuantity());
        importLogEntity.setCreatedAt(LocalDate.now());
        importLogRepository.save(importLogEntity);
    }
}
