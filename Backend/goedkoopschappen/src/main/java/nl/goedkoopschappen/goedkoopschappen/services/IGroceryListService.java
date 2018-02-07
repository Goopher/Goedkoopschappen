package nl.goedkoopschappen.goedkoopschappen.services;

import nl.goedkoopschappen.goedkoopschappen.models.GroceryList;
import nl.goedkoopschappen.goedkoopschappen.models.Product;

import java.util.List;

public interface IGroceryListService {
    void create(GroceryList groceryListItem);

    List<GroceryList> findAll();
}
