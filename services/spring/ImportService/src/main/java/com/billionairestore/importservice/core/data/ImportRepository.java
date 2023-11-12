package com.billionairestore.importservice.core.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImportRepository extends JpaRepository<ImportEntity, String>{
    ImportEntity findByProductId(String ProductId);


}


