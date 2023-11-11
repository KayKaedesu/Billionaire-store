package com.billionairestore.productservice.query;

import com.billionairestore.productservice.core.data.ProductEntity;
import com.billionairestore.productservice.core.data.ProductRepository;
import com.billionairestore.productservice.core.events.ProductCreatedEvent;
import com.billionairestore.productservice.core.events.ProductDeletedEvent;
import com.billionairestore.productservice.core.events.ProductImageCreatedEvent;
import com.billionairestore.productservice.core.events.ProductPutEvent;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductEventsHandler {
    private final ProductRepository productRepository;

    public ProductEventsHandler(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @EventHandler
    public void on(ProductPutEvent event){
        ProductEntity entity = productRepository.findByProductId(event.getProductId());
        if (entity == null) {
            throw new IllegalStateException("Entity with id " + event.getProductId() + " not found");
        }
        BeanUtils.copyProperties(event, entity);
        productRepository.save(entity);
    }

    @EventHandler
    public void on(ProductDeletedEvent event){
        ProductEntity entity = productRepository.findByProductId(event.getProductId());
        if (entity == null) {
            throw new IllegalStateException("Entity with id " + event.getProductId() + " not found");
        }
        productRepository.deleteByProductId(event.getProductId());
    }

    @EventHandler
    public void on(ProductCreatedEvent event){
        ProductEntity entity = new ProductEntity();
        BeanUtils.copyProperties(event, entity);
        productRepository.save(entity);
    }

    @EventHandler
    public void on(ProductImageCreatedEvent event){
        ProductEntity entity = productRepository.findByProductId(event.getProductId());
        if (entity == null) {
            throw new IllegalStateException("Entity with id " + event.getProductId() + " not found");
        }
        entity.setImageUrl(event.getImagePath());
        productRepository.save(entity);
    }
}
