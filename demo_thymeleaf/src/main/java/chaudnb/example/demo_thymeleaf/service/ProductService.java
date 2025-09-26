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
        if (productRepository.addProduct(product)) {
            return product;
        }
        return null;
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.updateProduct(product);
    }

    @Override
    public boolean deleteProduct(Product product) {
        return productRepository.deleteProduct(product);
    }

    @Override
    public Product findProductById(int id) {
        return productRepository.findProductById(id);
    }

    @Override
    public List<Product> findProductByName(String name) {
        return productRepository.findProductByName(name);
    }
}
