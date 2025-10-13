package chaudnb.example.cart.repository;

import chaudnb.example.cart.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<Product,Long> {
}
