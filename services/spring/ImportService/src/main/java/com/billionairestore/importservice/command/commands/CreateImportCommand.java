package com.billionairestore.importservice.command.commands;


import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Data
@Builder
public class CreateImportCommand {
    @TargetAggregateIdentifier
    private final String productId;
    private final String name;
    private final String category;
    private final Double buyPrice;
}
