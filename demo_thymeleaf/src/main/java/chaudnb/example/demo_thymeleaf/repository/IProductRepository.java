package chaudnb.example.demo_thymeleaf.repository;

import chaudnb.example.demo_thymeleaf.entity.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    boolean addProduct(Product product);
    Product updateProduct(Product product);
    boolean deleteProduct(Product product);
    Product findProductById(int id);
    List<Product> findProductByName(String name);
}
