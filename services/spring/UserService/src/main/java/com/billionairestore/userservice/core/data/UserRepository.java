package com.billionairestore.userservice.core.data;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    UserEntity findByUserId(String userId);
    List<UserEntity> removeByUserId(String userId);
}
