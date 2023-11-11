package com.billionairestore.productservice.query;

import com.billionairestore.productservice.core.data.ProductEntity;
import com.billionairestore.productservice.core.data.ProductRepository;
import com.billionairestore.productservice.query.rest.ProductRestModel;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductQueryHandler {
    private final ProductRepository productRepository;
    public ProductQueryHandler(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @QueryHandler
    public List<ProductRestModel> findProduct (FindProductQuery query){
        List<ProductRestModel> productRest = new ArrayList<>();
        List<ProductEntity> storedProduct = productRepository.findAll();
        for (ProductEntity productEntity: storedProduct){
            ProductRestModel productRestModel = new ProductRestModel();
            BeanUtils.copyProperties(productEntity, productRestModel);
            productRest.add(productRestModel);
        }
        return productRest;
    }
}
