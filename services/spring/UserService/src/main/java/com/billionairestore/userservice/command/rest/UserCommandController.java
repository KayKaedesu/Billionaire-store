package com.billionairestore.userservice.command.rest;

import com.billionairestore.userservice.command.create.CreateUserCommand;
import com.billionairestore.userservice.command.UserRole;
import com.billionairestore.userservice.command.create.DeleteUserCommand;
import com.billionairestore.userservice.command.create.UpdateUserCommand;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UserCommandController {
    private final Environment env;
    private final CommandGateway commandGateway;

    @Autowired
    public UserCommandController(Environment env, CommandGateway commandGateway){
        this.commandGateway = commandGateway;
        this.env = env;
    }

    @RequestMapping(value =  "/employee",method = RequestMethod.POST)
    public String addEmployee(@RequestBody CreateUserRestModel model){
        CreateUserCommand command = CreateUserCommand.builder()
                .aggregateId(UUID.randomUUID().toString())
                .userId(model.getName() + "_" + model.getUsername())
                .name(model.getName())
                .username(model.getUsername())
                .password(model.getPassword())
                .userRole(UserRole.EMPLOYEE)
                .imgPath(model.getImgPath())
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

    @RequestMapping(value =  "/employee",method = RequestMethod.DELETE)
    public String deleteEmployee(@RequestBody DeleteUserRestModel model){
        DeleteUserCommand command = DeleteUserCommand.builder()
                .aggregateId(UUID.randomUUID().toString())
                .userId(model.getUserId())
                .name(model.getName())
                .username(model.getUsername())
                .password(model.getPassword())
                .userRole(model.getUserRole())
                .imgPath(model.getImgPath())
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

    @RequestMapping(value =  "/employee",method = RequestMethod.PUT)
    public String putEmployee(@RequestBody UpdateUserRestModel model){
        UpdateUserCommand command = UpdateUserCommand.builder()
                .aggregateId(UUID.randomUUID().toString())
                .userId(model.getUserId())
                .name(model.getName())
                .username(model.getUsername())
                .password(model.getPassword())
                .userRole(model.getUserRole())
                .imgPath(model.getImgPath())
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
