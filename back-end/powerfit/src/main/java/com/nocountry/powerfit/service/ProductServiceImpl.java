package com.nocountry.powerfit.service;

import com.nocountry.powerfit.model.entity.Category;
import com.nocountry.powerfit.model.entity.Product;
import com.nocountry.powerfit.model.entity.User;
import com.nocountry.powerfit.model.exception.ResourceNotFoundException;
import com.nocountry.powerfit.model.mapper.ProductMapper;
import com.nocountry.powerfit.model.request.ProductRequest;
import com.nocountry.powerfit.model.response.ProductResponse;
import com.nocountry.powerfit.model.response.UserResponse;
import com.nocountry.powerfit.repository.IProductRepository;
import com.nocountry.powerfit.service.abstraction.CategoryService;
import com.nocountry.powerfit.service.abstraction.IImageService;
import com.nocountry.powerfit.service.abstraction.IProductService;
import com.nocountry.powerfit.service.abstraction.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements IProductService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private UserService userService;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private IProductRepository IProductRepository;

    private IImageService imageService;

    @Autowired
    private CategoryService categoryService;


    @Override
    @Transactional
    public ProductResponse add(List<MultipartFile> postImage, ProductRequest request) {
        try {
            UserResponse userResponse = userService.getUserInfo();
            if (userResponse == null)throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El usuario no inició sesión");
            LOGGER.warn("El usuario es: "+ userResponse.getEmail());

            /*new product*/
            Product product = productMapper.dtoToProduct(request, userResponse);
            product.setCarrousel(imageService.imagesPost(postImage));
            product.setCategory(categoryService.getByName(request.getCategory()).toString());

//            add image
            Product pCreated= IProductRepository.save(product);
            return productMapper.entityToDto(pCreated);
        } catch (NullPointerException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error de carga de producto o de conexión de base de datos");
        }

    }

    public List<ProductResponse> getProductForCategory(String name) throws ResourceNotFoundException {
        List<Product> products = IProductRepository.findByCategory(name);
        if(products.isEmpty()){
            throw new ResourceNotFoundException("No se encontró la categoría con el nombre " + name);
        }
        List<ProductResponse> productResponses = products.stream()
                .map(product -> productMapper.entityToDto(product))
                .collect(Collectors.toList());

        return productResponses;
    }

    @Override
    public ProductRequest save(Product product) {
        IProductRepository.save(product);
        return null;
    }

    @Override
    public ProductResponse getById(Long id) throws ResourceNotFoundException {
        Product product = IProductRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró el producto con el id: " + id));
        return productMapper.entityToDto(product);
    }

    @Override
    public List<ProductResponse> getAll() {
        return IProductRepository.findAll().stream().filter(p -> p.getStock() != 0).map(productMapper::entityToDto).collect(Collectors.toList());

    }

    @Override
    public void delete(Long id) {
        Optional<Product> product = IProductRepository.findById(id);
        if(product.isPresent()){
            IProductRepository.deleteById(id);
        }
    }

    @Override
    public List<ProductResponse> findByName(String name) {
        List<Product> products = IProductRepository.findByName(name);
        return productMapper.entityToDtoList(products);
    }
}
