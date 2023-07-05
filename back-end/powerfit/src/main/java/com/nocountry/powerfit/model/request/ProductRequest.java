package com.nocountry.powerfit.model.request;

import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductRequest {

    private Long id;
    @NotEmpty(message = "Name cannot be empty")
    private String name;
    @NotEmpty(message = "Description cannot be empty")
    private String description;
    @NotNull(message = "You must specify the price")
    @Min(value = 0, message = "The minimum price is 0")
    private double price;
    private boolean stock;
    @Min(value = 0, message = "The quantity must be a positive number")
    private Integer quantity;
    @NotNull(message = "Id cannot by null")
    private Long categoryId;

    

}