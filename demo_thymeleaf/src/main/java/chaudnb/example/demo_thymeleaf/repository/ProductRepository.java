package chaudnb.example.demo_thymeleaf.repository;

import chaudnb.example.demo_thymeleaf.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepository implements  IProductRepository {
    private static List<Product> products = new ArrayList<>();
    static {
        products.add(new Product(1, "Áo phông", "Áo phông nam cổ tròn, màu trắng", 150000.0, 100));
        products.add(new Product(2, "Quần jeans", "Quần jeans xanh, ống côn", 450000.0, 50));
        products.add(new Product(3, "Giày thể thao", "Giày thể thao nam, màu đen", 800000.0, 75));
        products.add(new Product(4, "Đồng hồ", "Đồng hồ đeo tay nữ, mặt tròn", 1200000.0, 30));
        products.add(new Product(5, "Ba lô", "Ba lô du lịch đa năng, chống nước", 650000.0, 60));    }
    @Override
    public List<Product> findAll() {
        return products;
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
