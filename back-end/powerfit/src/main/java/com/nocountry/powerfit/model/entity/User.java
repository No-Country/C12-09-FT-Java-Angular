package com.nocountry.powerfit.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
@AllArgsConstructor
@Builder
@Table(name = "users")
@NoArgsConstructor
public class User /*implements UserDetails*/ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Pattern(regexp = "^[A-Za-z]+$", message = "Please enter a valid name")
    @Size(max = 15, message = "Please enter a valid name")
    @NotNull(message = "Name can't be null")
    private String name;

    @Pattern(regexp = "\\d{10}", message = "Por favor ingrese un documento válido")
    private Long document;

    @Pattern(regexp = "^[A-Za-z]+$", message = "Please enter a last name")
    @Size(max = 15, message = "Please enter a valid last name")
    @NotNull(message = "Last name can't be null")
    private String lastName;

    @NotBlank(message = "Please enter an email")
    @Email(message = "Email must have a valid format")
    @NotNull(message = "Email can't be null.")
    private String email;

    @NotNull(message = "Password can't be null")
    @Size(min = 8, max = 250, message = "Password should have at least 8 characters")
    private String password;

    @NotNull(message = "Phone number can't be null.")
    @Pattern(regexp = "\\d{10}", message = "Please enter a valid phone number")
    private String phoneNumber;

    private String address;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    private Long postalCode;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime created;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    //@JoinColumn(name="image_id")
    //@OneToOne(cascade = CascadeType.REFRESH)
    //private Image image;

    @OneToMany(mappedBy = "user")
    private List<Bill> bill;

    /*@JoinColumn(name = "role_id")
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private Role role;*/


    /*@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }*/
}
