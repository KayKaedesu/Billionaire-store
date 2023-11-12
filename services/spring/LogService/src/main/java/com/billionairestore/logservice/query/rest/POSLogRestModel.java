package com.billionairestore.logservice.query.rest;

import lombok.Data;

import java.time.OffsetDateTime;
import java.util.Date;

@Data
public class POSLogRestModel {
    private String logId;
    private String userId;
    private String productId;
    private String name;
    private int quantity;
    private double price;
    private OffsetDateTime createdAt;
}
