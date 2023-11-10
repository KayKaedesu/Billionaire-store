package com.billionairestore.inventoryservice.core.data;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends JpaRepository<InventoryEntity, String> {

    @Override
    Optional<InventoryEntity> findById(String s);
}
