package com.nocountry.powerfit.controller;

import com.nocountry.powerfit.model.exception.CartNotFoundException;
import com.nocountry.powerfit.model.exception.ResourceNotFoundException;
import com.nocountry.powerfit.model.response.CartResponse;
import com.nocountry.powerfit.service.abstraction.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cart")
public class CartController {

    private final CartService cartService;

    @PostMapping("/{cartId}/products")
    public ResponseEntity<?> addProductsToCart(@PathVariable Long cartId, @RequestParam Long productId) {
        try {
            cartService.addProduct(cartId, productId);
            return ResponseEntity.ok().build();
        } catch (ResourceNotFoundException | CartNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{cartId}/product/{productId}")
    public ResponseEntity<Void> removeProductFromCart(@PathVariable Long cartId, @PathVariable Long productId) {
        try {
            cartService.removeProductFromCart(cartId, productId);
            return ResponseEntity.ok().build();
        } catch (ResourceNotFoundException | CartNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{cartId}/product/{productId}")
    public ResponseEntity<Void> updateProductQuantity(
            @PathVariable Long cartId,
            @PathVariable Long productId,
            @RequestParam Integer quantity) {
        try {
            cartService.updateProductQuantity(cartId, productId, quantity);
            return ResponseEntity.noContent().build();
        } catch (ResourceNotFoundException | CartNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{cartId}/products")
    public ResponseEntity<?> getCartProducts(@PathVariable Long cartId) {
        try {
            List<CartResponse> cartProducts = cartService.getCartProducts(cartId);
            return ResponseEntity.ok(cartProducts);
        } catch (ResourceNotFoundException | CartNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{cartId}/totalPrice")
    public ResponseEntity<Double> getCartTotalPrice(@PathVariable Long cartId) {
        try {
            double totalPrice = cartService.getCartTotalPrice(cartId);
            return ResponseEntity.ok(totalPrice);
        } catch (ResourceNotFoundException | CartNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{cartId}/isEmpty")
    public ResponseEntity<Boolean> isCartEmpty(@PathVariable Long cartId) {
        try {
            boolean isEmpty = cartService.isCartEmpty(cartId);
            return ResponseEntity.ok(isEmpty);
        } catch (CartNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{cartId}")
    public ResponseEntity<Void> clearCart(@PathVariable Long cartId) {
        try {
            cartService.clearCart(cartId);
            return ResponseEntity.ok().build();
        } catch (CartNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
