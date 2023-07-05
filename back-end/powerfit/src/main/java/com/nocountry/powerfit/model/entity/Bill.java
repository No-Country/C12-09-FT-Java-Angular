package com.nocountry.powerfit.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bills")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bills_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
    //private Cart cart;
    //private Date date;
}
