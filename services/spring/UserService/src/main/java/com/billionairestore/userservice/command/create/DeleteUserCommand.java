package com.billionairestore.userservice.command.create;

import com.billionairestore.userservice.command.UserRole;
import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

@Builder
@Data
public class DeleteUserCommand {
    @TargetAggregateIdentifier
    private final String aggregateId;
    private final String userId;
    private final String name;
    private final String username;
    private final String password;
    private final UserRole userRole;
    private final String imgPath;
}
