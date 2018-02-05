package nl.goedkoopschappen.goedkoopschappen.controller;


import nl.goedkoopschappen.goedkoopschappen.models.Product;
import nl.goedkoopschappen.goedkoopschappen.repositories.IProductRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProductRestController {

    private IProductRepository repository;

    public ProductRestController (IProductRepository repository){
        this.repository = repository;
    }

    @RequestMapping(value = "/products", params = "productName")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Product> home (@RequestParam(value = "productName")String searchString){
        return repository.findByProductNameContaining(searchString);
    }


}
