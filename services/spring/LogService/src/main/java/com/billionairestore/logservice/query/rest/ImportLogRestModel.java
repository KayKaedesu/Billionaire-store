package com.billionairestore.logservice.query.rest;

import lombok.Data;

import java.time.OffsetDateTime;
import java.util.Date;

@Data
public class ImportLogRestModel {
    private String logId;
    private String userId;
    private String productId;
    private String name;
    private int quantity;
    private double buyPrice;
    private OffsetDateTime createdAt;
}
