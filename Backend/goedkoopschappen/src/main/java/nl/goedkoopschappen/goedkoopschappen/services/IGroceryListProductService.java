package nl.goedkoopschappen.goedkoopschappen.services;

import nl.goedkoopschappen.goedkoopschappen.models.GroceryList;
import nl.goedkoopschappen.goedkoopschappen.models.GroceryListProduct;
import nl.goedkoopschappen.goedkoopschappen.models.Product;

import java.util.List;


public interface IGroceryListProductService {

    void create(GroceryListProduct groceryListProduct);

    List<GroceryListProduct> findAll();

    GroceryListProduct findOne(Long groceryListId);

    List<GroceryListProduct> findByGroceryList(GroceryList groceryList);

    GroceryListProduct findByProductAndGroceryList(Product product, GroceryList groceryList);



}
