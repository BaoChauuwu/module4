package chaudnb.example.cart.config;

import chaudnb.example.cart.entity.Product;
import chaudnb.example.cart.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    
    @Autowired
    private IProductRepository productRepository;
    
    @Override
    public void run(String... args) throws Exception {
        if (productRepository.count() == 0) {
            // Thêm dữ liệu mẫu đơn giản
            Product product1 = new Product();
            product1.setName("iPhone 15");
            product1.setPrice(29999000);
            product1.setDescription("iPhone 15 mới nhất");
            productRepository.save(product1);
            
            Product product2 = new Product();
            product2.setName("Samsung Galaxy S24");
            product2.setPrice(28999000);
            product2.setDescription("Samsung Galaxy S24 Ultra");
            productRepository.save(product2);
            
            Product product3 = new Product();
            product3.setName("MacBook Air");
            product3.setPrice(32999000);
            product3.setDescription("MacBook Air M3");
            productRepository.save(product3);
            
            Product product4 = new Product();
            product4.setName("Dell XPS 13");
            product4.setPrice(25999000);
            product4.setDescription("Dell XPS 13 laptop");
            productRepository.save(product4);
            
            System.out.println("Đã tạo " + productRepository.count() + " sản phẩm mẫu");
        }
    }
}