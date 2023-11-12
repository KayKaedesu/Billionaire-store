package com.billionairestore.posservice.command.rest;

import com.billionairestore.posservice.command.create.CreatePOSCommand;
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
                .POSId(UUID.randomUUID().toString())
                .userId(model.getUserId())
                .productList(model.getProductList())
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
