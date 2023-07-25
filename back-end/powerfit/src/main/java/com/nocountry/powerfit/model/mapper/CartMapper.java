package com.nocountry.powerfit.model.mapper;

import com.nocountry.powerfit.model.entity.Cart;
import com.nocountry.powerfit.model.entity.Product;
import com.nocountry.powerfit.model.request.CartRequest;
import com.nocountry.powerfit.model.response.CartResponse;
import com.nocountry.powerfit.model.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class CartMapper {

    private final ImageMapper imageMapper;
    public  CartResponse entityToDto(Cart cart) {
        return CartResponse.builder()
                .id(cart.getId())
                .user(cart.getUser())
                .nameUser("")
                .products(mapToDtoProduct(cart.getProducts()))
                .amount(cart.getAmount())
                .quantity(cart.getQuantity())
                .build();
    }

    public static Cart dtoToEntity(CartRequest cartRequest) {
        return Cart.builder()
                .id(cartRequest.getId())
                .user(cartRequest.getUser())
                .products(cartRequest.getProducts())
                .amount(BigDecimal.valueOf(cartRequest.getAmount()))
                .quantity(cartRequest.getQuantity())
                .build();
    }

    public CartResponse mapToDto(Cart cart) {
        return CartResponse.builder()
                .id(cart.getId())
                .amount(cart.getAmount())
                .products(mapToDtoProduct(cart.getProducts()))
                .build();
    }

    private List<ProductResponse> mapToDtoProduct(List<Product> products) {
        return products.stream()
                .map(this::mapProductToProductResponse)
                .collect(Collectors.toList());
    }

    private ProductResponse mapProductToProductResponse(Product product) {
        ProductResponse response = new ProductResponse();
        response.setId(product.getId());
        response.setName(product.getName());
        response.setPrice(response.getPrice());
        response.setStock(product.getStock());
        response.setDescription(product.getDescription());
        response.setCategory(product.getCategory());
        response.setImgList(imageMapper.mapToDtoImagesList(product.getCarrousel()));
        return response;
    }


}
