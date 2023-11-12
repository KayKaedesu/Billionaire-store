package com.billionairestore.userservice.query.rest;

import com.billionairestore.userservice.command.UserRole;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class UserRestModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 635568648992769632L;
    private String userId;
    private String name;
    private String username;
    private String password;
    private UserRole userRole;
    private String imgPath;
}
