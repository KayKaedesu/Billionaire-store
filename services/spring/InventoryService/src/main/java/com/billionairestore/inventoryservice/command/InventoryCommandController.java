package com.billionairestore.inventoryservice.command;

import com.billionairestore.inventoryservice.command.commands.CreateInventoryCommand;
import com.billionairestore.inventoryservice.command.commands.DeleteInventoryCommand;
import com.billionairestore.inventoryservice.command.rest.CreateInventoryRestModel;
import com.billionairestore.inventoryservice.command.rest.DeleteInventoryRestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class InventoryCommandController {

    private final Environment env;
    private final CommandGateway commandGateway;

    @Autowired
    public InventoryCommandController(Environment env, CommandGateway commandGateway){
        this.commandGateway = commandGateway;
        this.env = env;
    }

    @RequestMapping(value =  "/inventory",method = RequestMethod.POST)
    public String createInventory(@RequestBody CreateInventoryRestModel model){
        CreateInventoryCommand command = CreateInventoryCommand.builder()
                .aggregateId(UUID.randomUUID().toString())
                .productId(model.getProductId())
                .quantity(0)
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

    @RequestMapping(value =  "/inventory",method = RequestMethod.DELETE)
    public String deleteInventory(@RequestBody DeleteInventoryRestModel model){
        DeleteInventoryCommand command = DeleteInventoryCommand.builder()
                .aggregateId(UUID.randomUUID().toString())
                .productId(model.getProductId())
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
