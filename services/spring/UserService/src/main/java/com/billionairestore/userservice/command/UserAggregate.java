package com.billionairestore.userservice.command;

import com.billionairestore.userservice.command.create.CreateUserCommand;
import com.billionairestore.userservice.command.create.DeleteUserCommand;
import com.billionairestore.userservice.command.create.UpdateUserCommand;
import com.billionairestore.userservice.core.events.UserCreatedEvent;
import com.billionairestore.userservice.core.events.UserDeletedEvent;
import com.billionairestore.userservice.core.events.UserUpdatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class UserAggregate {
    @AggregateIdentifier
    private String aggregateId;
    private String userId;
    private String name;
    private String username;
    private String password;
    private UserRole userRole;
    private String imgPath;

    public UserAggregate(){}
    @CommandHandler
    public UserAggregate(CreateUserCommand createUserCommand){
        if (createUserCommand.getName().isBlank() || createUserCommand.getUsername().isBlank() || createUserCommand.getPassword().isBlank() || createUserCommand.getImgPath().isBlank()){
            throw new IllegalArgumentException("กรอกให้ครบ");
        }
        UserCreatedEvent userCreatedEvent = new UserCreatedEvent();
        BeanUtils.copyProperties(createUserCommand, userCreatedEvent);
        AggregateLifecycle.apply(userCreatedEvent);
    }

    @CommandHandler
    public UserAggregate(DeleteUserCommand deleteUserCommand){
        if (deleteUserCommand.getUserId().isBlank()){
            throw new IllegalArgumentException("err");
        }
        UserDeletedEvent userDeletedEvent = new UserDeletedEvent();
        BeanUtils.copyProperties(deleteUserCommand, userDeletedEvent);
        AggregateLifecycle.apply(userDeletedEvent);
    }

    @CommandHandler
    public UserAggregate(UpdateUserCommand updateUserCommand){
        if (updateUserCommand.getName().isBlank() || updateUserCommand.getUsername().isBlank() || updateUserCommand.getPassword().isBlank() || updateUserCommand.getImgPath().isBlank()){
            throw new IllegalArgumentException("กรอกให้ครบด้วย");
        }
        UserUpdatedEvent userUpdatedEvent = new UserUpdatedEvent();
        BeanUtils.copyProperties(updateUserCommand, userUpdatedEvent);
        AggregateLifecycle.apply(userUpdatedEvent);
    }

    @EventSourcingHandler
    public void on(UserCreatedEvent userCreatedEvent) {
        System.out.println("ON AGGREGATE " + userCreatedEvent);
        this.aggregateId = userCreatedEvent.getAggregateId();
        this.userId = userCreatedEvent.getUserId();
        this.name = userCreatedEvent.getName();
        this.username = userCreatedEvent.getUsername();
        this.password = userCreatedEvent.getPassword();
        this.userRole = userCreatedEvent.getUserRole();
        this.imgPath = userCreatedEvent.getImgPath();
    }

    @EventSourcingHandler
    public void on(UserDeletedEvent userDeletedEvent) {
        System.out.println("ON AGGREGATE " + userDeletedEvent);
        this.aggregateId = userDeletedEvent.getAggregateId();
        this.userId = userDeletedEvent.getUserId();
        this.name = userDeletedEvent.getName();
        this.username = userDeletedEvent.getUsername();
        this.password = userDeletedEvent.getPassword();
        this.userRole = userDeletedEvent.getUserRole();
        this.imgPath = userDeletedEvent.getImgPath();
    }

    @EventSourcingHandler
    public void on(UserUpdatedEvent userUpdatedEvent) {
        System.out.println("ON AGGREGATE " + userUpdatedEvent);
        this.aggregateId = userUpdatedEvent.getAggregateId();
        this.userId = userUpdatedEvent.getUserId();
        this.name = userUpdatedEvent.getName();
        this.username = userUpdatedEvent.getUsername();
        this.password = userUpdatedEvent.getPassword();
        this.userRole = userUpdatedEvent.getUserRole();
        this.imgPath = userUpdatedEvent.getImgPath();
    }
}
