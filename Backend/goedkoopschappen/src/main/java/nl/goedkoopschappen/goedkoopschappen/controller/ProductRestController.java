package nl.goedkoopschappen.goedkoopschappen.controller;


import nl.goedkoopschappen.goedkoopschappen.models.GroceryList;
import nl.goedkoopschappen.goedkoopschappen.models.GroceryListProduct;
import nl.goedkoopschappen.goedkoopschappen.models.Product;


import nl.goedkoopschappen.goedkoopschappen.services.IGroceryListProductService;
import nl.goedkoopschappen.goedkoopschappen.services.IGroceryListService;
import nl.goedkoopschappen.goedkoopschappen.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProductRestController {


    @Autowired
    private IProductService iProductService;

    @Autowired
    private IGroceryListService iGroceryListService;

    @Autowired
    private IGroceryListProductService iGroceryListProductService;


    @RequestMapping(value = "/products", params = "productName")
    public List<Product> findProductsByString (@RequestParam(value = "productName")String searchString){
        return iProductService.findByProductNameContaining(searchString);
    }

    @PostMapping(value="/addToCart")
    public String addToList( @RequestParam(value="groceryListId") Long id, @RequestBody Product product){
        GroceryList groceryList = iGroceryListService.findOne(id);
        if(groceryList == null) {
            iGroceryListService.create(new GroceryList());
            groceryList = iGroceryListService.findOne(id);
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

        System.out.println("Product added to grocery list, ProductID: " + product.toString() + " , grocery list: " + groceryList.getGroceryListName());
        return "Product: " + product.getProductName() + " added to List: " + groceryList.getGroceryListName();

    }

    @RequestMapping(value = "/groceryList", params = "listId")
    public List<GroceryListProduct> getGroceryList(@RequestParam(value = "listId")Long id){

        List<GroceryListProduct> glp = iGroceryListProductService.findByGroceryList(iGroceryListService.findOne(id));


        return iGroceryListProductService.findByGroceryList(iGroceryListService.findOne(id));
    }

    @RequestMapping(value = "/groceryLists")
    public List<GroceryList> getGroceryLists(){

        return iGroceryListService.findAll();
    }

    @PostMapping(value="/createGroceryList")
    public String createGroceryList(@RequestParam(value = "groceryListName")String name){

        Timestamp timestamp = Timestamp.valueOf(LocalDateTime.now());
        GroceryList groceryList = new GroceryList();
        groceryList.setGroceryListName(name);
        groceryList.setTimestamp(timestamp);

        GroceryList newGroceryList = iGroceryListService.create(groceryList);

        return "New grocery list created with id: " + newGroceryList.getGroceryListId();
    }


}
