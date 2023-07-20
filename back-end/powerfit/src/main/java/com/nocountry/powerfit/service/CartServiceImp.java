package com.nocountry.powerfit.service;

import com.nocountry.powerfit.model.entity.Cart;
import com.nocountry.powerfit.model.entity.Product;
import com.nocountry.powerfit.model.exception.CartNotFoundException;
import com.nocountry.powerfit.model.exception.ResourceNotFoundException;
import com.nocountry.powerfit.model.mapper.CartMapper;
import com.nocountry.powerfit.model.response.CartResponse;
import com.nocountry.powerfit.repository.ICartRepository;
import com.nocountry.powerfit.repository.IProductRepository;
import com.nocountry.powerfit.service.abstraction.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartServiceImp implements CartService {

    private final CartMapper cartMapper;
    private final ICartRepository cartRepository;
    private final IProductRepository productRepository;

    @Override
    public CartResponse addProduct(Long cartId, Long productId) throws CartNotFoundException, ResourceNotFoundException {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new CartNotFoundException("Carrito no encontrado"));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));

        cart.addProduct(product);
        cartRepository.save(cart);

        return cartMapper.entityToDto(cart);
    }

    @Override
    public void removeProductFromCart(Long cartId, Long productId) throws ResourceNotFoundException, CartNotFoundException {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new CartNotFoundException("Carrito no encontrado"));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));

        if (!cart.getProducts().contains(product)) {
            throw new ResourceNotFoundException("Producto no encontrado en el carrito");
        }

        cart.getProducts().remove(product);
        cartRepository.save(cart);

    }

    @Override
    public CartResponse updateProductQuantity(Long cartId, Long productId, int stock) throws ResourceNotFoundException, CartNotFoundException {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new CartNotFoundException("Carrito no encontrado"));

        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Producto no encontrado"));

        if (!cart.getProducts().contains(product)) {
            throw new ResourceNotFoundException("Producto no encontrado en el carrito");
        }

        product.setStock(stock);

        cartRepository.save(cart);

        return CartMapper.entityToDto(cart);
    }

    @Override
    public List<CartResponse> getCartProducts(Long cartId) throws ResourceNotFoundException, CartNotFoundException {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new CartNotFoundException("Carrito no encontrado"));

        List<Product> cartItems = cart.getProducts();

        List<CartResponse> cartResponses = cartItems.stream()
                .map(product -> CartMapper.entityToDto(cart))
                .collect(Collectors.toList());

        return cartResponses;
    }


    @Override
    public double getCartTotalPrice(Long cartId) throws CartNotFoundException {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new CartNotFoundException("Carrito no encontrado"));

        List<Product> cartItems = cart.getProducts();

        double totalPrice = cartItems.stream()
                .mapToDouble(Product::getPrice)
                .sum();

        return totalPrice;
    }

    @Override
    public boolean isCartEmpty(Long cartId) throws CartNotFoundException {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new CartNotFoundException("Carrito no encontrado"));

        boolean isEmpty = cart.getProducts().isEmpty();

        return isEmpty;
    }

    @Override
    public void clearCart(Long cartId) throws CartNotFoundException {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new CartNotFoundException ("Carrito no encontrado"));

        cart.getProducts().clear();

        cartRepository.save(cart);
    }

}

