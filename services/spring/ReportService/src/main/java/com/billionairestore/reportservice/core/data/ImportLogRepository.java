package com.billionairestore.reportservice.core.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ImportLogRepository extends JpaRepository<ImportLogEntity, Long> {
    List<ImportLogEntity> findByCreatedAtBetween(Date startDate, Date endDate);
}
