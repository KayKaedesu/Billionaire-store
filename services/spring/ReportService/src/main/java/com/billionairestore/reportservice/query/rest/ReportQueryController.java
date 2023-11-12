package com.billionairestore.reportservice.query.rest;

import com.billionairestore.reportservice.query.FindImportReportQuery;
import com.billionairestore.reportservice.query.FindPOSReportQuery;
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
        FindPOSReportQuery findPOSReportQuery = new FindPOSReportQuery();
        System.out.println(queryGateway.query(
                findImportReportQuery, ResponseTypes.multipleInstancesOf(ImportReportRestModel.class)
        ).join());
        System.out.println(queryGateway.query(
                findPOSReportQuery, ResponseTypes.multipleInstancesOf(POSReportRestModel.class)
        ).join());
        return queryGateway.query(
                findImportReportQuery, ResponseTypes.multipleInstancesOf(ImportReportRestModel.class)
        ).join();
    }
}
