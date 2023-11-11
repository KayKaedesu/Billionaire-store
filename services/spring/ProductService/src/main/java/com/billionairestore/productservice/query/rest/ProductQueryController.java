package com.billionairestore.productservice.query.rest;

import com.billionairestore.productservice.query.FindProductQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ProductQueryController {
    private final QueryGateway queryGateway;
    public ProductQueryController(QueryGateway queryGateway){
        this.queryGateway = queryGateway;
    }
    @RequestMapping(value =  "/products",method = RequestMethod.GET)
    public List<ProductRestModel> getShelf(){
        FindProductQuery findProductQuery = new FindProductQuery();
        return queryGateway.query(
                findProductQuery, ResponseTypes.multipleInstancesOf(ProductRestModel.class)
        ).join();
    }
}
