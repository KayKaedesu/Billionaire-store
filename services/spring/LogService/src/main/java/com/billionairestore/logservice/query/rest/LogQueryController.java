package com.billionairestore.logservice.query.rest;

import com.billionairestore.logservice.query.FindImportLogQuery;
import com.billionairestore.logservice.query.FindPOALogQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LogQueryController {
    private final QueryGateway queryGateway;
    public LogQueryController(QueryGateway queryGateway){
        this.queryGateway = queryGateway;
    }
    @RequestMapping(value =  "/log/poa",method = RequestMethod.GET)
    public List<POALogRestModel> getPOA(){
        FindPOALogQuery findPOALogQuery = new FindPOALogQuery();
        return queryGateway.query(
                findPOALogQuery, ResponseTypes.multipleInstancesOf(POALogRestModel.class)
        ).join();
    }
    @RequestMapping(value =  "/log/import",method = RequestMethod.GET)
    public List<ImportLogRestModel> getImport(){
        FindImportLogQuery findImportLogQuery = new FindImportLogQuery();
        return queryGateway.query(
                findImportLogQuery, ResponseTypes.multipleInstancesOf(ImportLogRestModel.class)
        ).join();
    }
}
