package com.billionairestore.reportservice.query;

import com.billionairestore.reportservice.core.data.ImportReportEntity;
import com.billionairestore.reportservice.core.data.ImportReportRepository;
import com.billionairestore.reportservice.core.data.POSReportEntity;
import com.billionairestore.reportservice.core.data.POSReportRepository;
import com.billionairestore.reportservice.query.rest.ImportReportRestModel;
import com.billionairestore.reportservice.query.rest.POSReportRestModel;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ReportQueryHandler {
    private final ImportReportRepository importReportRepository;
    private final POSReportRepository posReportRepository;
    public ReportQueryHandler(ImportReportRepository importReportRepository, POSReportRepository posReportRepository){
        this.importReportRepository = importReportRepository;
        this.posReportRepository = posReportRepository;
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
    @QueryHandler
    public List<POSReportRestModel> findPOS(FindPOSReportQuery query){
        List<POSReportRestModel> posRest = new ArrayList<>();
        List<POSReportEntity> storedImport = posReportRepository.findAll();
        for (POSReportEntity posReportEntity: storedImport){
            POSReportRestModel posReportRestModel = new POSReportRestModel();
            BeanUtils.copyProperties(posReportEntity, posReportRestModel);
            posRest.add(posReportRestModel);
        }
        return posRest;
    }
}
