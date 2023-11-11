package com.billionairestore.importservice.query.rest;

import com.billionairestore.importservice.query.FindImportsQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/imports")
public class ImportQueryController {
    private final QueryGateway queryGateway;

    public ImportQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping
    public List<ImportRestModel> getImport(){
        FindImportsQuery findImportsQuery = new FindImportsQuery();
        return  queryGateway.query(
                findImportsQuery,
                ResponseTypes.multipleInstancesOf(ImportRestModel.class)
        ).join();
    }
}
