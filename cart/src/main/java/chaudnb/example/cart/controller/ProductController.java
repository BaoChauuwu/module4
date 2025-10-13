package chaudnb.example.cart.controller;

import chaudnb.example.cart.entity.Product;
import chaudnb.example.cart.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    
    @Autowired
    private IProductService productService;
    
    @GetMapping("/")
    public String index(Model model) {
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "index";
    }
    
    @GetMapping("/product/{id}")
    public String productDetail(@PathVariable Long id, Model model) {
        Optional<Product> product = productService.findById(id);
        if (product.isPresent()) {
            model.addAttribute("product", product.get());
            return "product-detail";
        }
        return "redirect:/";
    }
}

