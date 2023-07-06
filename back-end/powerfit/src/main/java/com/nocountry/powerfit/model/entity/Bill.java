package com.nocountry.powerfit.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

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
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime date;
}
