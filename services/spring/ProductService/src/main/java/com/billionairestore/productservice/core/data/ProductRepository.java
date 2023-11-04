package com.billionairestore.productservice.core.data;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, String> {
    @Override
    List<ProductEntity> findAll();

    @Override
    List<ProductEntity> findAllById(Iterable<String> strings);
}
