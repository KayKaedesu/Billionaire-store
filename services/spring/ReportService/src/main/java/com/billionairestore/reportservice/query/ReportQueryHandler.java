package com.billionairestore.reportservice.query;

import com.billionairestore.reportservice.core.data.ImportLogRepository;
import com.billionairestore.reportservice.core.data.POSLogRepository;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReportQueryHandler {
    private final ImportLogRepository importLogRepository;
    private final POSLogRepository posLogRepository;
    public ReportQueryHandler(ImportLogRepository importLogRepository, POSLogRepository posLogRepository){
        this.importLogRepository = importLogRepository;
        this.posLogRepository = posLogRepository;
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
