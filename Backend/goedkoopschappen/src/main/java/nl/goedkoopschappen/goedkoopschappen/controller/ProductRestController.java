package nl.goedkoopschappen.goedkoopschappen.controller;


import nl.goedkoopschappen.goedkoopschappen.models.Product;
import nl.goedkoopschappen.goedkoopschappen.repositories.IProductRepository;


import nl.goedkoopschappen.goedkoopschappen.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductRestController {


    @Autowired
    private IProductService iProductService;


    @RequestMapping(value = "/products", params = "productName")
    public List<Product> home (@RequestParam(value = "productName")String searchString){

        return iProductService.findByProductNameContaining(searchString);
    }

    @PostMapping
    public List<Product> addToList()




}
