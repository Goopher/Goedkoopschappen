package nl.goedkoopschappen.goedkoopschappen.services;

import nl.goedkoopschappen.goedkoopschappen.models.GroceryListItem;
import nl.goedkoopschappen.goedkoopschappen.models.Product;

import java.util.List;

public interface IGroceryListService {
    void create(GroceryListItem groceryListItem);

    List<Product> findAll();
}
