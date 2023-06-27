package rw.rca.springsecuritytemplate.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rw.rca.springsecuritytemplate.Models.Cart;
import rw.rca.springsecuritytemplate.Repositories.CartRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    private final CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void addToCart(Long userId, Long productId, int quantity) {
        Cart cartItem = new Cart();
        cartItem.setUserId(userId);
        cartItem.setProductId(productId);
        cartItem.setQuantity(quantity);
        cartRepository.save(cartItem);
    }

    public void updateCartItem(Long cartItemId, int quantity) {
        Optional<Cart> optionalCartItem = cartRepository.findById(cartItemId);
        if (optionalCartItem.isPresent()) {
            Cart cartItem = optionalCartItem.get();
            cartItem.setQuantity(quantity);
            cartRepository.save(cartItem);
        }
    }

    public void removeFromCart(Long cartItemId) {
        cartRepository.deleteById(cartItemId);
    }

    public List<Cart> getCartItems(Long userId) {
        return cartRepository.findByUserId(userId);
    }
}

