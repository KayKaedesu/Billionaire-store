package com.billionairestore.productservice.core.data;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {
    ProductEntity findByProductId(String productId);

    void deleteByProductId(String productId);

}
