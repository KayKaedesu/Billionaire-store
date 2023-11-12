package com.billionairestore.inventoryservice.query.rest;

import com.billionairestore.inventoryservice.query.FindInventoryQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class InventoryQueryController {
    private final QueryGateway queryGateway;
    public InventoryQueryController(QueryGateway queryGateway){
        this.queryGateway = queryGateway;
    }
    @RequestMapping(value =  "/inventory",method = RequestMethod.GET)
    public List<InventoryRestModel> getShelf(){
        FindInventoryQuery findInventoryQuery = new FindInventoryQuery();
        return queryGateway.query(
                findInventoryQuery, ResponseTypes.multipleInstancesOf(InventoryRestModel.class)
        ).join();
    }
}
