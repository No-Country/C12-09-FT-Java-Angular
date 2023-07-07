package com.nocountry.powerfit.model.mapper;

import com.nocountry.powerfit.model.entity.Cart;
import com.nocountry.powerfit.model.entity.User;
import com.nocountry.powerfit.model.request.CartRequest;

public class CartMapper {
    public Cart dtoToCart(CartRequest cartRequest){
        return Cart.builder()
                .id(cartRequest.getId())
                .user(cartRequest.getUser())
                .total(cartRequest.getTotal())
                .products(cartRequest.getProducts())
                .build();
    }
}
