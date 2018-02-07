package nl.goedkoopschappen.goedkoopschappen.dao;

import nl.goedkoopschappen.goedkoopschappen.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProductDAO extends JpaRepository<Product, Long> {
    List<Product> findAll();

    List<Product> findByProductNameContaining(String searchString);

    Product findByProductId(Long productId);
}
