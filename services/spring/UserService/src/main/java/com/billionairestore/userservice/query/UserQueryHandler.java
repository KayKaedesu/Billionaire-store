package com.billionairestore.userservice.query;

import com.billionairestore.core.rabbit.RabbitQueue;
import com.billionairestore.userservice.config.RabbitRegisterConfig;
import com.billionairestore.userservice.core.data.UserEntity;
import com.billionairestore.userservice.core.data.UserRepository;
import com.billionairestore.userservice.query.rest.UserRestModel;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
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
//    @RabbitListener(queues = "get-all")
//    public Object findUser(String bruh){
////        List<UserRestModel> usersRest = new ArrayList<>();
////        List<UserEntity> storedUsers = userRepository.findAll();
////        for (UserEntity userEntity: storedUsers){
////            UserRestModel userRestModel = new UserRestModel();
////            BeanUtils.copyProperties(userEntity, userRestModel);
////            usersRest.add(userRestModel);
////        }
////        Object obj = usersRest.toArray();
////        obj.
////        System.out.println(obj);
////        List<Object> objectList = new ArrayList<Object>();
////        objectList.addAll(Arrays.asList(userRepository.findAll()));
////        System.out.println(objectList);
//        List<UserEntity> storedUsers = userRepository.findAll();
//        System.out.println(storedUsers.getClass());
////        for (UserEntity userEntity: storedUsers){
////            UserRestModel userRestModel = new UserRestModel();
////            BeanUtils.copyProperties(userEntity, userRestModel);
////            usersRest.add(userRestModel);
////        }
//        return storedUsers.get(0);
//    }
}
