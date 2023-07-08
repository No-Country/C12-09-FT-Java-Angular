package com.nocountry.powerfit.model.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@Getter @Setter
@Entity
@Table(name = "cities")
@AllArgsConstructor
@NoArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "city")
    private List<User> user;

    private String name;
}
