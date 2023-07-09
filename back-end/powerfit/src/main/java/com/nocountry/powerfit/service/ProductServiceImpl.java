package com.nocountry.powerfit.service;

import com.nocountry.powerfit.model.entity.Category;
import com.nocountry.powerfit.model.entity.Product;
import com.nocountry.powerfit.model.entity.User;
import com.nocountry.powerfit.model.mapper.ProductMapper;
import com.nocountry.powerfit.model.request.ProductRequest;
import com.nocountry.powerfit.model.response.ProductResponse;
import com.nocountry.powerfit.model.response.UserResponse;
import com.nocountry.powerfit.repository.IProductRepository;
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
import javax.persistence.EntityNotFoundException;
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

    //@Autowired
//    private ImageService imageService;

    //@Autowired
//    private CategoryService categoryService;


//    @Override
//    @Transactional
//    public ProductResponse add(List<MultipartFile> postImage, ProductRequest request) {
//        try {
//            User user = userService.getUserInfo(); // falta metodo en UserService
//            if (user == null)throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not logged in");
//            LOGGER.warn("The user is:"+user.getEmail());
//
//            /*new product*/
//            Product product = productMapper.dtoToProduct(request, user);
//            product.setCarrousel(imageService.imagesPost(postImage));
//            product.setCategory(categoryService.findById(request.getCategoryId()));
//
//            add image
//            Product pCreated= IProductRepository.save(product);
//            return productMapper.entityToDto(pCreated);
//        } catch (NullPointerException e) {
//            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product loading error or database connection error");
//        }
//
//    }

    private List<Product> getProductForCategory(Long idProduct) {
        Optional<Product> product = IProductRepository.findById(idProduct);
        if (product.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found or has been deleted");
        }
        return product.get().getCategory().getProducts();
    }

    @Override
    public ProductRequest save(Product product) {
        IProductRepository.save(product);
        return null;
    }

    @Override
    public ProductResponse getById(Long id) {
        Product product = IProductRepository.findById(id).orElseThrow();
        if (!product.isStock()) {
            throw new EntityNotFoundException("Product not found or deleted");
        }
        return productMapper.entityToDto(product);
    }

    @Override
    public List<ProductResponse> getAll() {
        return IProductRepository.findAll().stream().filter(p -> p.isStock()).map(productMapper::entityToDto).collect(Collectors.toList());

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
