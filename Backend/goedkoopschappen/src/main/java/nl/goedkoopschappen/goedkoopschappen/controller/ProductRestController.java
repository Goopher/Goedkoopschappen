package nl.goedkoopschappen.goedkoopschappen.controller;


import nl.goedkoopschappen.goedkoopschappen.models.GroceryList;
import nl.goedkoopschappen.goedkoopschappen.models.GroceryListProduct;
import nl.goedkoopschappen.goedkoopschappen.models.Product;


import nl.goedkoopschappen.goedkoopschappen.services.IGroceryListProductService;
import nl.goedkoopschappen.goedkoopschappen.services.IGroceryListService;
import nl.goedkoopschappen.goedkoopschappen.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class ProductRestController {


    @Autowired
    private IProductService iProductService;

    @Autowired
    private IGroceryListService iGroceryListService;

    @Autowired
    private IGroceryListProductService iGroceryListProductService;

    @RequestMapping(value = "/products", params = "productName")
    public List<Product> home (@RequestParam(value = "productName")String searchString){
        return iProductService.findByProductNameContaining(searchString);
    }

    @PostMapping(value="/addToCart")
    public String addToList( @RequestBody Product product){

        GroceryList groceryList = iGroceryListService.findOne(1L);
        if(groceryList == null) {
            iGroceryListService.create(new GroceryList());
            groceryList = iGroceryListService.findOne(1L);
        }

        GroceryListProduct groceryListProduct = iGroceryListProductService.findByProductAndGroceryList(product, groceryList);
        if(groceryListProduct == null){
            GroceryListProduct gLP = new GroceryListProduct();
            gLP.setGroceryList(groceryList);
            gLP.setProduct(product);
            gLP.setAmount(1);
            iGroceryListProductService.create(gLP);
        } else {
            groceryListProduct.setAmount(groceryListProduct.getAmount()+1);
            iGroceryListProductService.create(groceryListProduct);
        }

        System.out.println("Product added to grocery list, ProductID: " + product.toString() + " , grocery list ID: " + groceryList.getGroceryListId());
        return "Product added to grocery list, ProductID: " + product.toString() + " , grocery list ID: " + groceryList.getGroceryListId();
    }

    @RequestMapping(value = "/grocerylist", params = "listId")
    public GroceryList getGroceryList(@RequestParam(value = "listId")Long id){

        return iGroceryListService.findOne(id);
    }


}
