package com.billionairestore.userservice.query;

import com.billionairestore.userservice.core.data.UserEntity;
import com.billionairestore.userservice.core.data.UserRepository;
import com.billionairestore.userservice.query.rest.UserRestModel;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserQueryHandler {
    private final UserRepository userRepository;
    public UserQueryHandler(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    @QueryHandler
    public List<UserRestModel> findUser(FindUserQuery query){
        List<UserRestModel> usersRest = new ArrayList<>();
        List<UserEntity> storedUsers = userRepository.findAll();
        for (UserEntity userEntity: storedUsers){
            UserRestModel userRestModel = new UserRestModel();
            BeanUtils.copyProperties(userEntity, userRestModel);
            usersRest.add(userRestModel);
        }
        return usersRest;
    }
}
