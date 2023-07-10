package com.nocountry.powerfit.controller;

import com.nocountry.powerfit.model.entity.Product;
import com.nocountry.powerfit.model.request.ProductRequest;
import com.nocountry.powerfit.model.response.ProductResponse;
import com.nocountry.powerfit.repository.IProductRepository;
import com.nocountry.powerfit.service.abstraction.IProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
@Api(value = "Product Controller", description = "Product functionalities")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private IProductService iProductService;

//    @ApiOperation(value = "Registration of a product", notes = "Returns product created")
//    @PostMapping("/add")
//    public ResponseEntity<ProductResponse> uploadFiles(
//            @RequestParam(value="postimages", required = false) List<MultipartFile> postImage ,
//            @RequestPart(value ="product", required = true) ProductRequest request) {
//        return ResponseEntity.status(HttpStatus.CREATED).body(iProductService.add(postImage, request));
//
//    }

    @GetMapping("/all")
    @ApiOperation(value = "Find all products ", notes = "Returns list products")
    public ResponseEntity<List<ProductResponse>> getAll() {
        List<ProductResponse> response = iProductService.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Find by id ", notes = "Returns one Product")
    public ResponseEntity<?> getById(@PathVariable Long id) {
        ProductResponse response = iProductService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Find by id and delete ", notes = "Returns http 204")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        iProductService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity<ProductResponse> updateProduct(@PathVariable("id") Long id, @Validated @RequestBody Product product) {
//        Product updatedProduct = iProductService.update(id ,product);
//        if (updatedProduct == null) {
//            return ResponseEntity.notFound().build();
//        }
//        ProductResponse productResponse = new ProductResponse();
//        productResponse.setId(product.getId());
//        productResponse.setName(product.getName());
//        productResponse.setDescription(product.getDescription());
//        productResponse.setPrice(product.getPrice());
//        productResponse.setCategory(product.getCategory().toString());
//        productResponse.setStock(true);
//
//        iProductService.save(productResponse);
//
//        return ResponseEntity.ok(productResponse);
//
//    }

}