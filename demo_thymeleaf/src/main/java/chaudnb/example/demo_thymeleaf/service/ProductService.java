package chaudnb.example.demo_thymeleaf.service;

import chaudnb.example.demo_thymeleaf.entity.Product;
import chaudnb.example.demo_thymeleaf.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductService implements IProductService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Product product) {
        return null;
    }

    @Override
    public boolean deleteProduct(Product product) {
        return false;
    }

    @Override
    public Product findProductById(int id) {
        return null;
    }

    @Override
    public List<Product> findProductByName(String name) {
        return List.of();
    }
}
