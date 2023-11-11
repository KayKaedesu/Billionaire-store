package com.billionairestore.userservice.command.rest;

import com.billionairestore.userservice.command.UserRole;
import lombok.Data;

@Data
public class UpdateUserRestModel {
    private String userId;
    private String name;
    private String username;
    private String password;
    private UserRole userRole;
    private String imgPath;
}
