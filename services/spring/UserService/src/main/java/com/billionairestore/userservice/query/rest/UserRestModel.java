package com.billionairestore.userservice.query.rest;

import com.billionairestore.userservice.command.UserRole;
import lombok.Data;

@Data
public class UserRestModel {
    private String userId;
    private String name;
    private String username;
    private String password;
    private UserRole userRole;
    private String imgPath;
}
