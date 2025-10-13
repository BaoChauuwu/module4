package chaudnb.example.cart.service;

import chaudnb.example.cart.entity.Cart;
import chaudnb.example.cart.entity.Product;

public interface ICartService {
    void addProduct(Product product);
    void removeProduct(Product product);
    void updateQuantity(Product product, int quantity);
    Cart getCart();
    void clearCart();
}

