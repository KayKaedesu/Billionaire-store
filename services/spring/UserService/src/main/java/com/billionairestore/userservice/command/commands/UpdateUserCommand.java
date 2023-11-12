package com.billionairestore.userservice.command.commands;

import com.billionairestore.userservice.command.UserRole;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
@Builder
@Data
public class UpdateUserCommand {
    @TargetAggregateIdentifier
    private final String aggregateId;
    private final String userId;
    private final String name;
    private final String username;
    private final String password;
    private final UserRole userRole;
    private final String imgPath;
}
