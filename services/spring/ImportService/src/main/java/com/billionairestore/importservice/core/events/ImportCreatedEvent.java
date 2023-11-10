package com.billionairestore.importservice.core.events;

import lombok.Data;

@Data
public class ImportCreatedEvent {
    private String importId;
    private String productId;
    private String name;
    private String category;
    private Double buyPrice;
}
