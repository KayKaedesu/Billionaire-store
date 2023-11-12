package com.billionairestore.reportservice.core.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface POSReportRepository extends JpaRepository<POSReportEntity, Long> {
    List<POSReportEntity> findByCreatedAtBetween(Date startDate, Date endDate);
}
