package chaudnb.example.demo_thymeleaf.controller;

import chaudnb.example.demo_thymeleaf.entity.Product;
import chaudnb.example.demo_thymeleaf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/students")
    public String showStudents( Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "/student/listStudent";

    }
}
