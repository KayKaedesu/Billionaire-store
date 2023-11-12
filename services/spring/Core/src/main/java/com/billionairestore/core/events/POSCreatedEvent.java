package com.billionairestore.core.events;

import lombok.Builder;
import lombok.Data;

import java.lang.reflect.Array;
import java.util.List;

@Data
@Builder
public class POSCreatedEvent {
    private String aggregateId;
//    private String POSId;
    private String userId;
    private List<Object> productList;
}
