package com.nocountry.powerfit.model.entity;

import lombok.*;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
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

    @NonNull
    @NotBlank(message = "A name is required")
    @NotEmpty(message = "Name can't be null")
    private String name;

    @NonNull
    @NotBlank(message = "a last name is Required")
    @NotEmpty(message = "Last name can't be null")
    private String lastName;

    @NotBlank(message = "Email cannot be empty.")
    @NotEmpty(message = "Email can't be null.")
    @NonNull
    @Email
    private String email;

    @NonNull
    @NotBlank(message = "Password cannot be empty.")
    @Size(min = 8, max = 250, message = "Password should have at least 8 characters")
    private String password;

    @NonNull
    @NotEmpty(message = "Phone number can't be empty")
    @NotBlank(message = "Phone number can't be empty.")
    private String phoneNumber;

    private String address;

    private String city;

    private Long postalCode;

    private Date created;

    @JoinColumn(name = "cart_id")
    @OneToOne(cascade = CascadeType.ALL)
    private Cart cart;

    /*@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Bill> bill = new ArrayList<>();

    @JoinColumn(name="image_id")
    @OneToOne(cascade = CascadeType.REFRESH)
    private Image image;

    @JoinColumn(name = "role_id")
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
