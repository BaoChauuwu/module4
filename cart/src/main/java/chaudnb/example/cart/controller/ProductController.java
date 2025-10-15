package chaudnb.example.cart.controller;

import chaudnb.example.cart.entity.Cart;
import chaudnb.example.cart.entity.Product;
import chaudnb.example.cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/products")
@SessionAttributes("cart")
public class ProductController {
    
    @Autowired
    private IProductService productService;
    
    @ModelAttribute("cart")
    public Cart getCart() {
        return new Cart();
    }
    
    @GetMapping("/shop")
    public ModelAndView shop(@ModelAttribute("cart") Cart cart) {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Product> products = productService.findAll();
        modelAndView.addObject("products", products);
        modelAndView.addObject("cartItemCount", cart.countItemQuantity());
        return modelAndView;
    }
    
    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable("id") Long id,
                           @ModelAttribute("cart") Cart cart,
                           @RequestParam(name = "action", defaultValue = "continue") String action) {
        Optional<Product> product = productService.findById(id);
        if (!product.isPresent()) {
            return "redirect:/products/shop";
        }
        if (action.equals("show")) {
            cart.addProduct(product.get());
            return "redirect:/cart";
        }
        cart.addProduct(product.get());
        return "redirect:/products/shop";
    }
    
    @GetMapping("/detail/{id}")
    public ModelAndView detail(@PathVariable("id") Long id, @ModelAttribute("cart") Cart cart) {
        Optional<Product> product = productService.findById(id);
        if (!product.isPresent()) {
            return new ModelAndView("redirect:/products/shop");
        } else {
            ModelAndView modelAndView = new ModelAndView("product-detail");
            modelAndView.addObject("product", product.get());
            modelAndView.addObject("cartItemCount", cart.countItemQuantity());
            return modelAndView;
        }
    }
    
    @PostMapping("/detail/{id}/add")
    public String addToCartFromDetail(@PathVariable("id") Long id,
                                    @RequestParam(defaultValue = "1") int quantity,
                                    @ModelAttribute("cart") Cart cart) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            for (int i = 0; i < quantity; i++) {
                cart.addProduct(product.get());
            }
        }
        return "redirect:/products/detail/" + id;
    }
}

