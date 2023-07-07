package com.nocountry.powerfit.service.abstraction;

import com.nocountry.powerfit.model.entity.Cart;
import com.nocountry.powerfit.model.request.CartRequest;
import com.nocountry.powerfit.model.response.CartResponse;

public interface CartService {
    //CartResponse getCartProducts()
    //void deleteCartProduct(ProductRequest request);
    //CartResponse updateCart(CartRequest request);
    Cart addToCart(Integer productId);
}
