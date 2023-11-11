package com.billionairestore.posservice.command.rest;

import com.billionairestore.posservice.command.create.CreatePOSCommand;
import com.billionairestore.posservice.command.create.DeletePOSCommand;
import com.billionairestore.posservice.command.create.UpdatePOSCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class POSCommandController {
    private final Environment env;
    private final CommandGateway commandGateway;

    @Autowired
    public POSCommandController(Environment env, CommandGateway commandGateway){
        this.commandGateway = commandGateway;
        this.env = env;
    }

    @RequestMapping(value =  "/pos",method = RequestMethod.POST)
    public String addPOS(@RequestBody CreatePOSRestModel model){
        CreatePOSCommand command = CreatePOSCommand.builder()
                .aggregateId(UUID.randomUUID().toString())
                .POSId(model.getPOSId())
                .employeeId(model.getEmployeeId())
                .productId(model.getProductId())
                .sellPrice(model.getSellPrice())
                .quantity(model.getQuantity())
                .build();
        String result;
        try {
            result = commandGateway.sendAndWait(command);
        }
        catch (Exception e){
             result = e.getLocalizedMessage();
        }
        return result;
    }

    @RequestMapping(value =  "/pos",method = RequestMethod.DELETE)
    public String deletePOS(@RequestBody DeletePOSRestModel model){
        DeletePOSCommand command = DeletePOSCommand.builder()
                .aggregateId(UUID.randomUUID().toString())
                .POSId(model.getPOSId())
                .employeeId(model.getEmployeeId())
                .productId(model.getProductId())
                .sellPrice(model.getSellPrice())
                .quantity(model.getQuantity())
                .build();
        String result;
        try {
            result = commandGateway.sendAndWait(command);
        }
        catch (Exception e){
            result = e.getLocalizedMessage();
        }
        return result;
    }

    @RequestMapping(value =  "/pos",method = RequestMethod.PUT)
    public String putPOS(@RequestBody UpdatePOSRestModel model){
        UpdatePOSCommand command = UpdatePOSCommand.builder()
                .aggregateId(UUID.randomUUID().toString())
                .POSId(model.getPOSId())
                .employeeId(model.getEmployeeId())
                .productId(model.getProductId())
                .sellPrice(model.getSellPrice())
                .quantity(model.getQuantity())
                .build();
        String result;
        try {
            result = commandGateway.sendAndWait(command);
        }
        catch (Exception e){
            result = e.getLocalizedMessage();
        }
        return result;
    }
}
