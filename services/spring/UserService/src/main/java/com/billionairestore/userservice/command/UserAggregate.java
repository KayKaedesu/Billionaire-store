package com.billionairestore.userservice.command;

import com.billionairestore.userservice.core.events.UserCreatedEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

@Aggregate
public class UserAggregate {
    @AggregateIdentifier
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
        System.out.println("agg");
    }

    @EventSourcingHandler
    public void on(UserCreatedEvent userCreatedEvent) {
        System.out.println("ON AGGREGATE " + userCreatedEvent);
        this.userId = userCreatedEvent.getUserId();
        this.name = userCreatedEvent.getName();
        this.username = userCreatedEvent.getUsername();
        this.password = userCreatedEvent.getPassword();
        this.userRole = userCreatedEvent.getUserRole();
        this.imgPath = userCreatedEvent.getImgPath();
    }
}
