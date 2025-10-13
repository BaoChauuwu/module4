package chaudnb.example.cart.repository;

import chaudnb.example.cart.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICartRepository extends JpaRepository<Cart,Integer> {
}
