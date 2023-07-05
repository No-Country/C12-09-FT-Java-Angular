package com.nocountry.powerfit.model.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;
    @NotEmpty(message = "Name cannot be empty")
    private String name;
    @NotEmpty(message = "Description cannot be empty")
    private String description;
    @NotNull(message = "You must specify the price")
    @Min(value = 0, message = "The minimum price is 0")
    private Double price;
    private boolean stock;
    @Min(value = 0, message = "The quantity must be a positive number")
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user; //confirmar si agregamos lista de productos a User (un usuario puede tener muchos productos)
/*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    private Cart cart;

    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "product", // falta agregar objeto product a la clase Image
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Image> images;
*/
}