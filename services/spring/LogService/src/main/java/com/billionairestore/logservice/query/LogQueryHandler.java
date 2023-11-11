package com.billionairestore.logservice.query;

import com.billionairestore.logservice.core.data.ImportLogRepository;
import com.billionairestore.logservice.core.data.POALogRepository;
import com.billionairestore.logservice.query.rest.ImportLogRestModel;
import com.billionairestore.logservice.query.rest.POALogRestModel;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public class LogQueryHandler {
    private final ImportLogRepository importLogRepository;
    private final POALogRepository poaLogRepository;
    public LogQueryHandler(ImportLogRepository importLogRepository, POALogRepository poaLogRepository){
        this.importLogRepository = importLogRepository;
        this.poaLogRepository = poaLogRepository;
    }
    @QueryHandler
    public List<POALogRestModel> findPOA(FindPOALogQuery query){
        List<POALogRestModel> POARest = new ArrayList<>();
        List<UserEntity> storedUsers = userRepository.findAll();
        for (UserEntity userEntity: storedUsers){
            UserRestModel userRestModel = new UserRestModel();
            BeanUtils.copyProperties(userEntity, userRestModel);
            usersRest.add(userRestModel);
        }
        return usersRest;
    }
    @QueryHandler
    public List<ImportLogRestModel> findImport(FindImportLogQuery query){
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
