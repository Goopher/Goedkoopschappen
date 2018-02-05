package nl.goedkoopschappen.goedkoopschappen.services;

import nl.goedkoopschappen.goedkoopschappen.models.Product;

import java.util.List;

public interface IProductService {

    void create(Product product);

    List<Product> findAll();

    List<Product> findByProductNameContaining(String searchString);
}
