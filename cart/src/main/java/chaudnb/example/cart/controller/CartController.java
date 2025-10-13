package chaudnb.example.cart.controller;

import chaudnb.example.cart.entity.Cart;
import chaudnb.example.cart.entity.Product;
import chaudnb.example.cart.service.ICartService;
import chaudnb.example.cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cart")
public class CartController {
    
    @Autowired
    private ICartService cartService;
    
    @Autowired
    private IProductService productService;
    
    @GetMapping
    public String viewCart(Model model) {
        Cart cart = cartService.getCart();
        model.addAttribute("cart", cart);
        return "cart";
    }
    
    @PostMapping("/add/{productId}")
    public String addToCart(@PathVariable Long productId, @RequestParam(defaultValue = "1") int quantity) {
        productService.findById(productId).ifPresent(product -> {
            for (int i = 0; i < quantity; i++) {
                cartService.addProduct(product);
            }
        });
        return "redirect:/cart";
    }
    
    @PostMapping("/update/{productId}")
    public String updateQuantity(@PathVariable Long productId, @RequestParam int quantity) {
        productService.findById(productId).ifPresent(product -> {
            cartService.updateQuantity(product, quantity);
        });
        return "redirect:/cart";
    }
    
    @PostMapping("/remove/{productId}")
    public String removeFromCart(@PathVariable Long productId) {
        productService.findById(productId).ifPresent(product -> {
            cartService.removeProduct(product);
        });
        return "redirect:/cart";
    }
    
    @PostMapping("/clear")
    public String clearCart() {
        cartService.clearCart();
        return "redirect:/cart";
    }
}
