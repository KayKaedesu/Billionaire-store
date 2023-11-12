package com.billionairestore.shelfservice.command;

import com.billionairestore.shelfservice.command.commands.*;
import com.billionairestore.shelfservice.command.rest.*;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class ShelfCommandController {
    private final Environment env;
    private final CommandGateway commandGateway;

    @Autowired
    public ShelfCommandController(Environment env, CommandGateway commandGateway){
        this.commandGateway = commandGateway;
        this.env = env;
    }


    @RequestMapping(value =  "/shelf",method = RequestMethod.POST)
    public String createShelf(@RequestBody CreateShelfRestModel model){
        CreateShelfCommand command = CreateShelfCommand.builder()
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

    @RequestMapping(value =  "/shelf",method = RequestMethod.DELETE)
    public String deleteShelf(@RequestBody DeleteShelfRestModel model){
        DeleteShelfCommand command = DeleteShelfCommand.builder()
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

    @RequestMapping(value =  "/shelf",method = RequestMethod.PUT)
    public String putShelf(@RequestBody UpdateShelfRestModel model){
        UpdateShelfCommand command = UpdateShelfCommand.builder()
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

    @RequestMapping(value = "/toShelf", method = RequestMethod.POST)
    public String addShelf(@RequestBody InventoryToShelfRestModel model) {
        InventoryToShelfCommand command = InventoryToShelfCommand.builder()
                .aggregateId(UUID.randomUUID().toString())
                .productId(model.getProductId())
                .quantity(model.getQuantity())
                .build();
        String result;
        try{
            result = commandGateway.sendAndWait(command);
        } catch (Exception e){
            result = e.getLocalizedMessage();
        }
        return result;
    }

    @RequestMapping(value = "/toInventory", method = RequestMethod.POST)
    public String addInventory(@RequestBody ShelfToInventoryRestModel model) {
        ShelfToInventoryCommand command = ShelfToInventoryCommand.builder()
                .aggregateId(UUID.randomUUID().toString())
                .productId(model.getProductId())
                .quantity(model.getQuantity())
                .build();
        String result;
        try{
            result = commandGateway.sendAndWait(command);
        } catch (Exception e){
            result = e.getLocalizedMessage();
        }
        return result;
    }
}
