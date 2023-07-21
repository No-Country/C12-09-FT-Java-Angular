package com.nocountry.powerfit.model.mapper;

import com.nocountry.powerfit.model.entity.Cart;
import com.nocountry.powerfit.model.request.CartRequest;
import com.nocountry.powerfit.model.response.CartResponse;
import org.springframework.stereotype.Component;

@Component
public class CartMapper {

    public static CartResponse entityToDto(Cart cart) {
        return CartResponse.builder()
                .id(cart.getId())
                .user(cart.getUser())
                .nameUser("")
                .products(cart.getProducts())
                .amount(cart.getAmount())
                .quantity(cart.getQuantity())
                .build();
    }

    public static Cart dtoToEntity(CartRequest cartRequest) {
        return Cart.builder()
                .id(cartRequest.getId())
                .user(cartRequest.getUser())
                .products(cartRequest.getProducts())
                .amount(cartRequest.getAmount())
                .quantity(cartRequest.getQuantity())
                .build();
    }
}
