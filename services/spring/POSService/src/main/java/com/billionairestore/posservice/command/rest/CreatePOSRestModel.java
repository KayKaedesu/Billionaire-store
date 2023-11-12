package com.billionairestore.posservice.command.rest;

import lombok.Data;

import java.lang.reflect.Array;

@Data
public class CreatePOSRestModel {
    private final String POSId;
    private final String userId;
    private final Array productList;
}
