package nl.goedkoopschappen.goedkoopschappen.controller;


import nl.goedkoopschappen.goedkoopschappen.models.GroceryList;
import nl.goedkoopschappen.goedkoopschappen.models.Product;


import nl.goedkoopschappen.goedkoopschappen.services.IGroceryListService;
import nl.goedkoopschappen.goedkoopschappen.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ProductRestController {


    @Autowired
    private IProductService iProductService;

    @Autowired
    private IGroceryListService iGroceryListService;

    private String currentQuery = "";

    @RequestMapping(value = "/products", params = "productName")
    public List<Product> home (@RequestParam(value = "productName")String searchString){
        currentQuery = searchString;
        return iProductService.findByProductNameContaining(searchString);
    }

    @PostMapping(value="/addToCart")
    public void addToList(@RequestBody Product product){



    }
}
