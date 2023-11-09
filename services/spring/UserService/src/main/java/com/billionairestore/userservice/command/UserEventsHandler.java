package com.billionairestore.userservice.command;

import com.billionairestore.userservice.core.data.UserEntity;
import com.billionairestore.userservice.core.data.UserRepository;
import com.billionairestore.userservice.core.events.UserCreatedEvent;
import com.billionairestore.userservice.core.events.UserDeletedEvent;
import com.billionairestore.userservice.core.events.UserUpdatedEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserEventsHandler {
    private final UserRepository userRepository;
    public UserEventsHandler(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @EventHandler
    public void on(UserCreatedEvent event){
        System.out.println("created");
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(event, userEntity);
        userRepository.save(userEntity);
    }

    @EventHandler
    public void on(UserDeletedEvent event){
        System.out.println("deleted");
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(event, userEntity);
        userRepository.delete(userEntity);
    }

    @EventHandler
    public void on(UserUpdatedEvent event){
        System.out.println("updated");
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(event, userEntity);
        userRepository.save(userEntity);
    }
}
