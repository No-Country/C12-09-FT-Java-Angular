package com.nocountry.powerfit.model.mapper;

import com.nocountry.powerfit.model.entity.Role;
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
                .role(Role.USER)
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
}
