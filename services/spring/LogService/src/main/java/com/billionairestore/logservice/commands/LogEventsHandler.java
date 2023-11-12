package com.billionairestore.logservice.commands;

import com.billionairestore.core.events.BuyProductCreatedEvent;
import com.billionairestore.core.events.CreatedEvent;
import com.billionairestore.core.events.POSCreatedEvent;
import com.billionairestore.logservice.commands.rest.ProductModel;
import com.billionairestore.logservice.core.data.ImportLogEntity;
import com.billionairestore.logservice.core.data.ImportLogRepository;
import com.billionairestore.logservice.core.data.POSLogEntity;
import com.billionairestore.logservice.core.data.POSLogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.type.DateTime;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

@Component
public class LogEventsHandler {
    private final ImportLogRepository importLogRepository;
    private static POSLogRepository posLogRepository;
    public LogEventsHandler(ImportLogRepository importLogRepository, POSLogRepository posLogRepository){
        this.importLogRepository = importLogRepository;
        this.posLogRepository = posLogRepository;
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
        importLogEntity.setBuyPrice(event.getQuantity() + event.getBuyPrice());
        importLogEntity.setQuantity(event.getQuantity());
        importLogEntity.setCreatedAt(LocalDate.now());
        importLogRepository.save(importLogEntity);
    }
    @EventHandler
    public static void on(POSCreatedEvent event) {
        for (Object object : event.getProductList()) {
            ObjectMapper objectMapper = new ObjectMapper();
            ProductModel productModel = objectMapper.convertValue(object, ProductModel.class);
            POSLogEntity posLogEntity = new POSLogEntity();
            posLogEntity.setLogId(UUID.randomUUID().toString());
            posLogEntity.setUserId(event.getUserId());
            posLogEntity.setProductId(productModel.getProductId());
            posLogEntity.setQuantity(productModel.getQuantity());
            posLogEntity.setSellPrice(productModel.getQuantity() * productModel.getSellPrice());
            posLogEntity.setCreatedAt(LocalDate.now());
            posLogRepository.save(posLogEntity);
        }
    }
}
