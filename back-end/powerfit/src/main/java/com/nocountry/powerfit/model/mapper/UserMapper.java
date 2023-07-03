package com.nocountry.powerfit.model.mapper;

import com.nocountry.powerfit.model.entity.User;
import com.nocountry.powerfit.model.request.RegisterRequest;
import com.nocountry.powerfit.model.request.UserRequest;
import com.nocountry.powerfit.model.response.AuthResponse;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.io.IOException;
@Component
@RequiredArgsConstructor
public class UserMapper {
    //private final PasswordEncoder passwordEncoder;

    public User RegisterToDto(RegisterRequest registerRequest) throws IOException{
        return User.builder()
                .name(registerRequest.getName())
                .lastName(registerRequest.getLastName())
                .email(registerRequest.getEmail())
                .password(registerRequest.getPassword()) //configurar con security luego
                //.password(passwordEncoder.encode(registerRequest.getPassword()))
                .phoneNumber(registerRequest.getPhoneNumber())
                .build();
    }

    public AuthResponse dtoToEntity(User user){
        return AuthResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .lastName(user.getLastName())
                .build();
    }
}
