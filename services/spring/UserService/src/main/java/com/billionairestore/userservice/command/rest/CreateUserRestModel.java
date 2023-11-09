package com.billionairestore.userservice.command.rest;

import lombok.Data;

@Data
public class CreateUserRestModel {
    private String name;
    private String username;
    private String password;
    private String imgPath;
}
