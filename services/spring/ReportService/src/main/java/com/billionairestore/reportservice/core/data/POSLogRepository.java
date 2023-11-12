package com.billionairestore.reportservice.core.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface POSLogRepository extends JpaRepository<POSLogEntity, Long> {
    List<POSLogEntity> findByCreatedAtBetween(Date startDate, Date endDate);
}
