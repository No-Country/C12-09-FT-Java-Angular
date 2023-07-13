package com.nocountry.powerfit.service.abstraction;

import com.nocountry.powerfit.model.entity.Category;
import com.nocountry.powerfit.model.entity.Product;
import com.nocountry.powerfit.model.exception.ResourceNotFoundException;
import com.nocountry.powerfit.model.request.ProductRequest;
import com.nocountry.powerfit.model.response.ProductResponse;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;


public interface IProductService {

    ProductResponse add(List<MultipartFile> postImage, ProductRequest request);
    ProductRequest save(Product product);
    void delete(Long id);
    ProductResponse getById(Long id) throws ResourceNotFoundException;
    List<ProductResponse> getAll();
    List<ProductResponse> findByName(String name) throws ResourceNotFoundException;
    List<ProductResponse> getProductsForCategory(String name) throws ResourceNotFoundException;


//    Product update(Long id, Product product);
}