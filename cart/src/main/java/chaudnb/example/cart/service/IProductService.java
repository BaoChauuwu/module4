package chaudnb.example.cart.service;

import chaudnb.example.cart.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    List<Product> findAll();
    Optional<Product> findById(Long id);
    Product save(Product product);

}
