package com.billionairestore.importservice.query;

import com.billionairestore.importservice.core.data.ImportEntity;
import com.billionairestore.importservice.core.data.ImportRepository;
import com.billionairestore.importservice.query.rest.ImportRestModel;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class importQueryHandler {
    private final ImportRepository importRepository;

    public importQueryHandler(ImportRepository importRepository){
        this.importRepository = importRepository;
    }

    @QueryHandler
    public List<ImportRestModel> findimport(FindImportsQuery query) {
        List<ImportRestModel> importsRest = new ArrayList<>();
        List<ImportEntity> storedImport = importRepository.findAll();
        for (ImportEntity importEntity : storedImport) {
            ImportRestModel productRestModel = new ImportRestModel();
            BeanUtils.copyProperties(importEntity, productRestModel);
            importsRest.add(productRestModel);
        }
        return importsRest;
    }
}
