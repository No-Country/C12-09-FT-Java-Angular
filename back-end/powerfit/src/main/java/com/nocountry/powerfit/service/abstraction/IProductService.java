package com.nocountry.powerfit.service.abstraction;

import com.nocountry.powerfit.model.entity.Product;
import com.nocountry.powerfit.model.request.ProductRequest;
import com.nocountry.powerfit.model.response.ProductResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;


public interface IProductService {

//    ProductResponse add(List<MultipartFile> postImage, ProductRequest request);
    ProductRequest save(Product product);
    void delete(Long id);
    ProductResponse getById(Long id);
    List<ProductResponse> getAll();
    List<ProductResponse> findByName(String name);


//    Product update(Long id, Product product);
}