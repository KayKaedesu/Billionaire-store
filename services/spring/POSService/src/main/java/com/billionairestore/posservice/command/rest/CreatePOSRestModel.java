package com.billionairestore.posservice.command.rest;

import lombok.Data;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Data
public class CreatePOSRestModel {
//    private final String POSId;
    private final String userId;
    private final List<Object> productList;
}
