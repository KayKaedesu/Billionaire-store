package com.billionairestore.authservice.entities;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserAuthRepository extends JpaRepository<UserEntity, String> {
    UserEntity findByUsernameAndPassword(String username, String password);
//    List<UserEntity> removeByUserId(String userId);
}
