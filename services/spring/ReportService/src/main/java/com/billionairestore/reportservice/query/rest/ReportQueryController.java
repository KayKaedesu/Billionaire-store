package com.billionairestore.reportservice.query.rest;

import com.billionairestore.reportservice.query.FindImportReportQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReportQueryController {
    private final QueryGateway queryGateway;
    public ReportQueryController(QueryGateway queryGateway){
        this.queryGateway = queryGateway;
    }
    @RequestMapping(value =  "/report",method = RequestMethod.GET)
    public List<ImportReportRestModel> getReport(){
        FindImportReportQuery findImportReportQuery = new FindImportReportQuery();
        return queryGateway.query(
                findImportReportQuery, ResponseTypes.multipleInstancesOf(ImportReportRestModel.class)
        ).join();
    }
}
