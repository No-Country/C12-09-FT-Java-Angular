package com.nocountry.powerfit.model.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserRequest {
    private Long id;
    private String address;
    private Long postalCode;
    private Long document;
    private String city;
    private String password;
    private String email;
    private String phoneNumber;
    private String name;
    private String lastName;
}
