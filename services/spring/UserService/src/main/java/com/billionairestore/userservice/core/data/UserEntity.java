package com.billionairestore.userservice.core.data;

import com.billionairestore.userservice.command.UserRole;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "users")
@Data
public class UserEntity implements Serializable{

    @Serial
    private static final long serialVersionUID = -3528785507428466022L;
    @Id
    @Column(unique = true)
    private String userId;
    @Column(unique = true)
    private String name;
    @Column(unique = true)
    private String username;
    @Column(unique = true)
    private String password;
    @Enumerated(EnumType.STRING)
    private UserRole userRole;
    private String imgPath;
}
