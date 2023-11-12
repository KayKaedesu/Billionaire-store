package com.billionairestore.shelfservice.core.data;


import org.springframework.data.jpa.repository.JpaRepository;


public interface InventoryRepository extends JpaRepository<InventoryEntity, String> {

    InventoryEntity findByProductId(String productId);
}
