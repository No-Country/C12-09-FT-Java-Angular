package com.nocountry.powerfit.model.mapper;

import com.nocountry.powerfit.model.entity.User;
import com.nocountry.powerfit.model.request.RegisterRequest;
import com.nocountry.powerfit.model.request.UserRequest;
import com.nocountry.powerfit.model.response.AuthResponse;
import com.nocountry.powerfit.model.response.UserResponse;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;

@Builder
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

    public UserResponse dtoToEntityUser(User user) {
        return UserResponse.builder()
                .id(user.getId())
                //.city(user.getCity())
                .address(user.getAddress())
                .name(user.getName())
                .phoneNumber(user.getPhoneNumber())
                .lastName(user.getLastName())
                .postalCode(user.getPostalCode())
                .email(user.getEmail())
                .build();
    }

    public User updateToDto(UserRequest updateRequest){
        return User.builder()
                .id(updateRequest.getId())
                .password(updateRequest.getPassword())
                .email(updateRequest.getEmail())
                .name(updateRequest.getName())
                .lastName(updateRequest.getLastName())
                .postalCode(updateRequest.getPostalCode())
                //.city(updateRequest.getCity())
                .address(updateRequest.getAddress())
                .phoneNumber(updateRequest.getPhoneNumber())
                //.document(updateRequest.getDocument())
                .build();
    }

    public User mapTo(RegisterRequest request) {
        return User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .lastName(request.getLastName())
                .password(request.getPassword())
                .phoneNumber(request.getPhoneNumber())
                .build();
    }
}
