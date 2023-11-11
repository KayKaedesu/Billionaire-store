package com.billionairestore.logservice.query;

import com.billionairestore.logservice.core.data.ImportLogEntity;
import com.billionairestore.logservice.core.data.ImportLogRepository;
import com.billionairestore.logservice.core.data.POSLogEntity;
import com.billionairestore.logservice.core.data.POSLogRepository;
import com.billionairestore.logservice.query.rest.ImportLogRestModel;
import com.billionairestore.logservice.query.rest.POSLogRestModel;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class LogQueryHandler {
    private final ImportLogRepository importLogRepository;
    private final POSLogRepository POSLogRepository;
    public LogQueryHandler(ImportLogRepository importLogRepository, POSLogRepository POSLogRepository){
        this.importLogRepository = importLogRepository;
        this.POSLogRepository = POSLogRepository;
    }
    @QueryHandler
    public List<POSLogRestModel> findPOA(FindPOSLogQuery query){
        List<POSLogRestModel> POARest = new ArrayList<>();
        List<POSLogEntity> storedPOALogs = POSLogRepository.findAll();
        for (POSLogEntity posLogEntity: storedPOALogs){
            POSLogRestModel posLogRestModel = new POSLogRestModel();
            BeanUtils.copyProperties(posLogEntity, posLogRestModel);
            POARest.add(posLogRestModel);
        }
        return POARest;
    }
    @QueryHandler
    public List<ImportLogRestModel> findImport(FindImportLogQuery query){
        List<ImportLogRestModel> importRest = new ArrayList<>();
        List<ImportLogEntity> storedImportLogs = importLogRepository.findAll();
        for (ImportLogEntity importLogEntity: storedImportLogs){
            ImportLogRestModel importLogRestModel = new ImportLogRestModel();
            BeanUtils.copyProperties(importLogEntity, importLogRestModel);
            importRest.add(importLogRestModel);
        }
        return importRest;
    }
}
