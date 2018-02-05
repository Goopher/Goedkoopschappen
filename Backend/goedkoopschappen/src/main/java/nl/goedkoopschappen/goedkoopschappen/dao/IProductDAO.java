package nl.goedkoopschappen.goedkoopschappen.dao;

import nl.goedkoopschappen.goedkoopschappen.models.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProductDAO extends CrudRepository<Product, Long>{
    List<Product> findAll();

    List<Product> findByProductNameContaining(String searchString);

}
