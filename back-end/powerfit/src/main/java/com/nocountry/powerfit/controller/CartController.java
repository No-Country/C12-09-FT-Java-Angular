package com.nocountry.powerfit.controller;

import com.nocountry.powerfit.model.exception.CartNotFoundException;
import com.nocountry.powerfit.model.exception.ResourceNotFoundException;
import com.nocountry.powerfit.model.response.CartResponse;
import com.nocountry.powerfit.service.abstraction.CartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Api(value = "Cart Controller", description = "Cart Controller")
@RequestMapping("/api/v1/cart")
public class CartController {

    private final CartService cartService;

    @PostMapping("/{cartId}/products")
    @ApiOperation(value = "Agrega producto al carrito")
    public ResponseEntity<?> addProductsToCart(@PathVariable Long cartId, @RequestParam Long productId) {
        try {
            cartService.addProduct(cartId, productId);
            return ResponseEntity.ok().build();
        } catch (ResourceNotFoundException | CartNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{cartId}/product/{productId}")
    @ApiOperation(value = "Elimina producto del carrito")
    public ResponseEntity<Void> removeProductFromCart(@PathVariable Long cartId, @PathVariable Long productId) {
        try {
            cartService.removeProductFromCart(cartId, productId);
            return ResponseEntity.ok().build();
        } catch (ResourceNotFoundException | CartNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{cartId}/product/{productId}")
    @ApiOperation(value = "Modifica la cantidad del producto en el carrito")
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
    @ApiOperation(value = "Obtiene productos del carrito")
    public ResponseEntity<?> getCartProducts(@PathVariable Long cartId) {
        try {
            List<CartResponse> cartProducts = cartService.getCartProducts(cartId);
            return ResponseEntity.ok(cartProducts);
        } catch (ResourceNotFoundException | CartNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{cartId}/totalPrice")
    @ApiOperation(value = "Obtiene precio total del carrito")
    public ResponseEntity<Double> getCartTotalPrice(@PathVariable Long cartId) {
        try {
            double totalPrice = cartService.getCartTotalPrice(cartId);
            return ResponseEntity.ok(totalPrice);
        } catch (ResourceNotFoundException | CartNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{cartId}/isEmpty")
    @ApiOperation(value = "Comprueba si el carrito está vacío")
    public ResponseEntity<Boolean> isCartEmpty(@PathVariable Long cartId) {
        try {
            boolean isEmpty = cartService.isCartEmpty(cartId);
            return ResponseEntity.ok(isEmpty);
        } catch (CartNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{cartId}")
    @ApiOperation(value = "Vacía el carrito")
    public ResponseEntity<Void> clearCart(@PathVariable Long cartId) {
        try {
            cartService.clearCart(cartId);
            return ResponseEntity.ok().build();
        } catch (CartNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
