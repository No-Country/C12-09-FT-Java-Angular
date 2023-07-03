package com.nocountry.powerfit.model.response;

import lombok.*;

import java.util.Date;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthResponse {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private String role;
    private Date created;
    //private String token;
}
