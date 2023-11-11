package com.billionairestore.authservice.services;

import com.billionairestore.authservice.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final JwtUtil jwt;
//    private final UserAuthRepository userAuthRepository;
    @Autowired
    public AuthService(final JwtUtil jwt){
        this.jwt = jwt;
//        this.userAuthRepository = userAuthRepository;
    }
    public AuthResponse logIn(UserEntity userEntity){
//            UserEntity result = userAuthRepository.findByUsernameAndPassword(authRequest.getUsername(), authRequest.getPassword());
            User user = User.builder()
                .userId(userEntity.getUserId())
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .role(userEntity.getUserRole())
                .build();
        String accessToken = jwt.generate(user, "ACCESS");
        String refreshToken = jwt.generate(user,"REFRESH");
        return new AuthResponse(accessToken, refreshToken);
//        catch (Exception e){
//            System.out.println(e.getLocalizedMessage());
//            return e.getMessage();
//        }
//        if (result == null){
//            return \
//        }
    }
}
