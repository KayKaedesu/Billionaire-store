package com.billionairestore.logservice.query.rest;

import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

@Data
public class POALogRestModel {
    private String logId;
    private String userId;
    private String productId;
    private String name;
    private int quantity;
    private double price;
    private Date createdAt;
}
