package nl.goedkoopschappen.goedkoopschappen.controller;


import nl.goedkoopschappen.goedkoopschappen.models.Product;
import nl.goedkoopschappen.goedkoopschappen.repositories.IProductRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductRestController {

    private IProductRepository repository;

    public ProductRestController (IProductRepository repository){
        this.repository = repository;
    }

    @RequestMapping(value = "/products", params = "productName")
    public List<Product> findByProductName (@RequestParam(value = "productName")String searchString){
        return repository.findByProductNameContaining(searchString);
    }

   @RequestMapping(value = "/additemtocart", method = RequestMethod.POST, params = "itemId")
    public boolean addItemToCart (@RequestParam(value="productId")Long productId) {
        return false;
   }




}
