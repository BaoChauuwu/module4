package chaudnb.example.cart.controller;

import chaudnb.example.cart.entity.Cart;
import chaudnb.example.cart.entity.Product;
import chaudnb.example.cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/cart")
@SessionAttributes("cart")
public class CartController {
    
    @Autowired
    private IProductService productService;
    
    @ModelAttribute("cart")
    public Cart getCart() {
        return new Cart();
    }
    
    @GetMapping
    public ModelAndView viewCart(@ModelAttribute("cart") Cart cart) {
        ModelAndView modelAndView = new ModelAndView("cart");
        modelAndView.addObject("cart", cart);
        return modelAndView;
    }
    
    @PostMapping("/update/{productId}")
    public String updateQuantity(@PathVariable Long productId, 
                               @RequestParam int quantity,
                               @ModelAttribute("cart") Cart cart) {
        Optional<Product> product = productService.findById(productId);
        if (product.isPresent()) {
            cart.updateQuantity(product.get(), quantity);
        }
        return "redirect:/cart";
    }
    
    @PostMapping("/remove/{productId}")
    public String removeFromCart(@PathVariable Long productId, @ModelAttribute("cart") Cart cart) {
        Optional<Product> product = productService.findById(productId);
        if (product.isPresent()) {
            cart.removeProduct(product.get());
        }
        return "redirect:/cart";
    }
    
    @PostMapping("/clear")
    public String clearCart(@ModelAttribute("cart") Cart cart) {
        cart.getProducts().clear();
        return "redirect:/cart";
    }
}
