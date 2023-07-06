package com.nocountry.powerfit.model.mapper;

import com.nocountry.powerfit.model.entity.Product;
import com.nocountry.powerfit.model.entity.User;
import com.nocountry.powerfit.model.request.ProductRequest;
import com.nocountry.powerfit.model.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class ProductMapper {

    private final ImageMapper imageMapper;

    public ProductResponse entityToDto(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .price(product.getPrice())
                .name(product.getName())
                .description(product.getDescription())
                .stock(product.isStock())
                .category(product.getCategory().getName())
                .imgList(product.getCarrousel().stream()
                        .map(imageMapper::imageToDto)
                        .collect(Collectors.toList()))
                .build();
    }

    public Product dtoToProduct(ProductRequest request, User user) {
        return Product.builder()
                .description(request.getDescription())
                .name(request.getName())
                .cart(null)
                .categoryId(request.getCategoryId())
                .price(request.getPrice())
                .stock(request.isStock())
                .build();
    }

    public List<ProductResponse> entityToDtoList(List<Product> products) {
        List<ProductResponse> responses = new ArrayList<>();
        ProductResponse productResponse;
        for (Product p: products){
            productResponse = new ProductResponse();
            productResponse.setId(p.getId());
            productResponse.setName(p.getName());
            productResponse.setDescription(p.getDescription());
            productResponse.setCategory(p.getCategory().getName());
            productResponse.setPrice(p.getPrice());
            productResponse.setStock(p.isStock());
            productResponse.setImgList(p.getCarrousel().stream().map(
                            imageMapper::imageToDto)
                    .collect(Collectors.toList()));
            responses.add(productResponse);
        }
        return responses;
    }

}