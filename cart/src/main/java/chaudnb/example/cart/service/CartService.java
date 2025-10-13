package chaudnb.example.cart.service;

import chaudnb.example.cart.entity.Cart;
import chaudnb.example.cart.entity.Product;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope
public class CartService implements ICartService {
    
    private Cart cart = new Cart();
    
    @Override
    public void addProduct(Product product) {
        cart.addProduct(product);
    }
    
    @Override
    public void removeProduct(Product product) {
        cart.removeProduct(product);
    }
    
    @Override
    public void updateQuantity(Product product, int quantity) {
        cart.updateQuantity(product, quantity);
    }
    
    @Override
    public Cart getCart() {
        return cart;
    }
    
    @Override
    public void clearCart() {
        cart.getProducts().clear();
    }
}

