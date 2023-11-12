package com.billionairestore.reportservice.query.rest;

import lombok.Data;

import java.util.Date;

@Data
public class ImportReportRestModel {
    private String logId;
    private String userId;
    private String productId;
    private String name;
    private int quantity;
    private double buyPrice;
    private Date createdAt;
}
