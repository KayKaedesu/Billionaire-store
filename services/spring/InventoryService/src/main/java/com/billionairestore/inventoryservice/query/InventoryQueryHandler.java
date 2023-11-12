package com.billionairestore.inventoryservice.query;

import com.billionairestore.inventoryservice.core.data.InventoryEntity;
import com.billionairestore.inventoryservice.core.data.InventoryRepository;
import com.billionairestore.inventoryservice.query.rest.InventoryRestModel;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InventoryQueryHandler {
    private final InventoryRepository inventoryRepository;
    public InventoryQueryHandler(InventoryRepository inventoryRepository){
        this.inventoryRepository = inventoryRepository;
    }
    @QueryHandler
    public List<InventoryRestModel> findInventory (FindInventoryQuery query){
        List<InventoryRestModel> inventoryRest = new ArrayList<>();
        List<InventoryEntity> storedInventory = inventoryRepository.findAll();
        for (InventoryEntity inventoryEntity: storedInventory){
            InventoryRestModel inventoryRestModel = new InventoryRestModel();
            BeanUtils.copyProperties(inventoryEntity, inventoryRestModel);
            inventoryRest.add(inventoryRestModel);
        }
        return inventoryRest;
    }
}
