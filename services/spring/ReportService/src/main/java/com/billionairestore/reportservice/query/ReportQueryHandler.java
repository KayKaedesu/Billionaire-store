package com.billionairestore.reportservice.query;

import com.billionairestore.reportservice.core.data.ImportReportEntity;
import com.billionairestore.reportservice.core.data.ImportReportRepository;
import com.billionairestore.reportservice.core.data.POSLogRepository;
import com.billionairestore.reportservice.query.rest.ImportReportRestModel;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReportQueryHandler {
    private final ImportReportRepository importReportRepository;
    private final POSLogRepository posLogRepository;
    public ReportQueryHandler(ImportReportRepository importReportRepository, POSLogRepository posLogRepository){
        this.importReportRepository = importReportRepository;
        this.posLogRepository = posLogRepository;
    }
    @QueryHandler
    public List<ImportReportRestModel> findImport(FindImportReportQuery query){
        List<ImportReportRestModel> importRest = new ArrayList<>();
        List<ImportReportEntity> storedImport = importReportRepository.findAll();
        for (ImportReportEntity importReportEntity: storedImport){
            ImportReportRestModel importReportRestModel = new ImportReportRestModel();
            BeanUtils.copyProperties(importReportEntity, importReportRestModel);
            importRest.add(importReportRestModel);
        }
        return importRest;
    }
}
