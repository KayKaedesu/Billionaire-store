package com.billionairestore.userservice.core.events;

import com.billionairestore.userservice.command.UserRole;
import lombok.Data;

@Data
public class UserCreatedEvent {
    private String aggregateId;
    private String userId;
    private String name;
    private String username;
    private String password;
    private UserRole userRole;
    private String imgPath;
}
