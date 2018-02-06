package nl.goedkoopschappen.goedkoopschappen.controller;


import nl.goedkoopschappen.goedkoopschappen.models.Product;
import nl.goedkoopschappen.goedkoopschappen.repositories.IProductRepository;

import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;


@RestController
public class ProductRestController {

    private IProductRepository repository;

    public ProductRestController (IProductRepository repository){
        this.repository = repository;
    }

    @RequestMapping(value = "/products", params = "productName")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Product> findByProductName (@RequestParam(value = "productName")String searchString){
        List<Product> products = repository.findByProductNameContaining(searchString);
        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return Integer.compare(o1.getPrice(), o2.getPrice());
            }
        });
        return products;
    }

   @RequestMapping(value = "/additemtocart", method = RequestMethod.POST, params = "itemId")
    public boolean addItemToCart (@RequestParam(value="productId")Long productId) {
        return false;
   }




}
