package chaudnb.example.demo_thymeleaf.service;

import chaudnb.example.demo_thymeleaf.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> findAll();
    Product addProduct(Product product);
    Product updateProduct(Product product);
    boolean deleteProduct(Product product);
    Product findProductById(int id);
    List<Product> findProductByName(String name);
}
