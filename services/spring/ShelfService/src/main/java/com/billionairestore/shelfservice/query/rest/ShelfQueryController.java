package com.billionairestore.shelfservice.query.rest;

import com.billionairestore.shelfservice.query.FindShelfQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ShelfQueryController {
    private final QueryGateway queryGateway;
    public ShelfQueryController(QueryGateway queryGateway){
        this.queryGateway = queryGateway;
    }
    @RequestMapping(value =  "/shelf",method = RequestMethod.GET)
    public List<ShelfRestModel> getShelf(){
        FindShelfQuery findShelfQuery = new FindShelfQuery();
        return queryGateway.query(
                findShelfQuery, ResponseTypes.multipleInstancesOf(ShelfRestModel.class)
        ).join();
    }
}
