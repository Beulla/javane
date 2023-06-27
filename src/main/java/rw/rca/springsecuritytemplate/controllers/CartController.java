package rw.rca.springsecuritytemplate.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rw.rca.springsecuritytemplate.Models.Cart;
import rw.rca.springsecuritytemplate.Models.Product;
import rw.rca.springsecuritytemplate.Models.Purchase;
import rw.rca.springsecuritytemplate.Models.User;
import rw.rca.springsecuritytemplate.Pojos.Request.CartRequest;
import rw.rca.springsecuritytemplate.Repositories.UserRepository;
import rw.rca.springsecuritytemplate.Services.CartService;
import rw.rca.springsecuritytemplate.Services.ProductService;
import rw.rca.springsecuritytemplate.Services.PurchaseService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/cart")
@PreAuthorize("permitAll()")
public class CartController {
    private final CartService cartService;
    private final ProductService productService;
    private final PurchaseService purchaseService;

    private final UserRepository userRepository;

    @Autowired
    public CartController(CartService cartService, ProductService productService, PurchaseService purchaseService, UserRepository userRepository) {
        this.cartService = cartService;
        this.productService = productService;
        this.purchaseService = purchaseService;
        this.userRepository = userRepository;
    }

    @PostMapping("/add")
    public ResponseEntity<String> addToCart(@RequestBody CartRequest cartRequest) {
        cartService.addToCart(cartRequest.getUserId(), cartRequest.getProductId(), cartRequest.getQuantity());
        return ResponseEntity.ok("Item added to cart successfully");
    }

    @PutMapping("/{cartItemId}")
    public ResponseEntity<String> updateCartItem(@PathVariable Long cartItemId, @RequestBody CartRequest cartRequest) {
        cartService.updateCartItem(cartItemId, cartRequest.getQuantity());
        return ResponseEntity.ok("Cart item updated successfully");
    }

    @DeleteMapping("/{cartItemId}")
    public ResponseEntity<String> removeFromCart(@PathVariable Long cartItemId) {
        cartService.removeFromCart(cartItemId);
        return ResponseEntity.ok("Item removed from cart successfully");
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<Cart>> getCartItems(@PathVariable Long userId) {
        List<Cart> cartItems = cartService.getCartItems(userId);
        return ResponseEntity.ok(cartItems);
    }

    @PostMapping("/purchase")
    public ResponseEntity<String> purchaseItems(@RequestBody CartRequest cartRequest) {
        // Retrieve user, product, and quantity from the request
        User user = userRepository.findById(cartRequest.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found"));

        Product product = productService.getProductById(String.valueOf(cartRequest.getProductId()));
        int quantity = cartRequest.getQuantity();

        // Perform purchase operation
        Purchase purchase = purchaseService.createPurchase(user, product, quantity);

        // Update any necessary data or perform additional operations

        return ResponseEntity.ok("Purchase successful");
    }
}

