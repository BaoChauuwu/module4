package chaudnb.example.validate_form.repository;

import chaudnb.example.validate_form.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {
}
