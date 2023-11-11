package com.billionairestore.shelfservice.core.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShelfRepository extends JpaRepository<ShelfEntity, String> {
    ShelfEntity findByProductId(String productId);

}
