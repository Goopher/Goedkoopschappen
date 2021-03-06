package nl.goedkoopschappen.goedkoopschappen.services;


import nl.goedkoopschappen.goedkoopschappen.models.GroceryList;
import nl.goedkoopschappen.goedkoopschappen.models.Product;

import java.util.List;

public interface IGroceryListService {

    GroceryList create(GroceryList groceryList);

    void delete(Long id);

    List<GroceryList> findAll();

    GroceryList findOne(Long id);
}
