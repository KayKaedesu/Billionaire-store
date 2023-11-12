package com.billionairestore.shelfservice.command;

import com.billionairestore.shelfservice.command.commands.CreateShelfCommand;
import com.billionairestore.shelfservice.command.commands.DeleteShelfCommand;
import com.billionairestore.shelfservice.command.commands.UpdateShelfCommand;
import com.billionairestore.shelfservice.command.rest.CreateShelfRestModel;
import com.billionairestore.shelfservice.command.rest.DeleteShelfRestModel;
import com.billionairestore.shelfservice.command.rest.UpdateShelfRestModel;
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
    public String addShelf(@RequestBody CreateShelfRestModel model){
        CreateShelfCommand command = CreateShelfCommand.builder()
                .aggregateId(UUID.randomUUID().toString())
//                .shelfId(UUID.randomUUID().toString())
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
//                .shelfId(model.getShelfId())
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
//                .shelfId(model.getShelfId())
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
