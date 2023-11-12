package com.billionairestore.reportservice.core.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ImportReportRepository extends JpaRepository<ImportReportEntity, Long> {
    List<ImportReportEntity> findByCreatedAtBetween(Date startDate, Date endDate);
}
