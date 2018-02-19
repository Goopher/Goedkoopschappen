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
@RequestMapping("/api")
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
    public String addToList( @RequestBody Product product){

        GroceryList groceryList = iGroceryListService.findOne(1L);


        if(groceryList == null) {
            iGroceryListService.create(new GroceryList());
            groceryList = iGroceryListService.findOne(1L);
        }

        groceryList.getProductList().add(product);
        iGroceryListService.create(groceryList);
        System.out.println("Product added to grocery list, ProductID: " + product.toString() + " , grocery list ID: " + groceryList.getGroceryListId());
        return "Product added to grocery list, ProductID: " + product.toString() + " , grocery list ID: " + groceryList.getGroceryListId();
    }
}
