package com.billionairestore.userservice.query.rest;

import com.billionairestore.userservice.config.RabbitRegisterConfig;
import com.billionairestore.userservice.core.data.UserEntity;
import com.billionairestore.userservice.query.FindUserQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class UserQueryController {
//    @Autowired
//    private RabbitTemplate rabbitTemplate;
    private final QueryGateway queryGateway;

    public UserQueryController(QueryGateway queryGateway){
        this.queryGateway = queryGateway;
    }
    @RequestMapping(value =  "/employee",method = RequestMethod.GET)
    public List<UserRestModel> getUser(){
        FindUserQuery findUserQuery = new FindUserQuery();
//        return ((String)rabbitTemplate.convertSendAndReceive(RabbitRegisterConfig.exchangeName, "get-all", ""));
        return queryGateway.query(
                findUserQuery, ResponseTypes.multipleInstancesOf(UserRestModel.class)
        ).join();
    }
}
