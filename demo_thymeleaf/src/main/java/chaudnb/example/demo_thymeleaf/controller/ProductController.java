package chaudnb.example.demo_thymeleaf.controller;

import chaudnb.example.demo_thymeleaf.entity.Product;
import chaudnb.example.demo_thymeleaf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    
    @GetMapping("")
    public String showProducts(Model model) {
        List<Product> productList = productService.findAll();
        model.addAttribute("productList", productList);
        return "product/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        return "product/add";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        Product savedProduct = productService.addProduct(product);
        if (savedProduct != null) {
            redirectAttributes.addFlashAttribute("message", "Thêm sản phẩm thành công!");
        } else {
            redirectAttributes.addFlashAttribute("error", "Thêm sản phẩm thất bại!");
        }
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Product product = productService.findProductById(id);
        if (product != null) {
            model.addAttribute("product", product);
            return "product/edit";
        }
        return "redirect:/products";
    }

    @PostMapping("/edit")
    public String updateProduct(@ModelAttribute Product product, RedirectAttributes redirectAttributes) {
        Product updatedProduct = productService.updateProduct(product);
        if (updatedProduct != null) {
            redirectAttributes.addFlashAttribute("message", "Cập nhật sản phẩm thành công!");
        } else {
            redirectAttributes.addFlashAttribute("error", "Cập nhật sản phẩm thất bại!");
        }
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id, RedirectAttributes redirectAttributes) {
        Product product = productService.findProductById(id);
        if (product != null && productService.deleteProduct(product)) {
            redirectAttributes.addFlashAttribute("message", "Xóa sản phẩm thành công!");
        } else {
            redirectAttributes.addFlashAttribute("error", "Xóa sản phẩm thất bại!");
        }
        return "redirect:/products";
    }

    @GetMapping("/search")
    public String searchProducts(@RequestParam String name, Model model) {
        List<Product> productList = productService.findProductByName(name);
        model.addAttribute("productList", productList);
        model.addAttribute("searchName", name);
        return "product/list";
    }
}
