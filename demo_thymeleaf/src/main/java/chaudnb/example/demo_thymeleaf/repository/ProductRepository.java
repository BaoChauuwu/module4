package chaudnb.example.demo_thymeleaf.repository;

import chaudnb.example.demo_thymeleaf.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepository implements  IProductRepository {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Product> findAll() {

        List<Product> products = new ArrayList<>();
        TypedQuery<Product> query = entityManager.createQuery("from Product",Product.class);
        products = query.getResultList();
        return products;
    }
    @Transactional
    @Override
    public boolean addProduct(Product product) {
        try {
            entityManager.persist(product);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Transactional
    @Override
    public Product updateProduct(Product product) {
        try {
            return entityManager.merge(product);
        } catch (Exception e) {
            return null;
        }
    }

    @Transactional
    @Override
    public boolean deleteProduct(Product product) {
        try {
            entityManager.remove(entityManager.merge(product));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Product findProductById(int id) {
        Product product = entityManager.find(Product.class,id);
        return product;
    }

    @Override
    public List<Product> findProductByName(String name) {
        try {
            TypedQuery<Product> query = entityManager.createQuery(
                "SELECT p FROM Product p WHERE p.name LIKE :name", Product.class);
            query.setParameter("name", "%" + name + "%");
            return query.getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
