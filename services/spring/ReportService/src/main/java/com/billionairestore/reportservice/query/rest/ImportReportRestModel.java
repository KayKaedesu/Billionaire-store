package com.billionairestore.reportservice.query.rest;

import lombok.Data;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Date;

@Data
public class ImportReportRestModel {
    private String logId;
    private String userId;
    private String productId;
    private String name;
    private Double quantity;
    private String category;
    private double buyPrice;
    private OffsetDateTime createdAt;
}
