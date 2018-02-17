package nl.goedkoopschappen.goedkoopschappen.dao;

import nl.goedkoopschappen.goedkoopschappen.models.GroceryList;
import nl.goedkoopschappen.goedkoopschappen.models.GroceryListProduct;
import nl.goedkoopschappen.goedkoopschappen.models.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IGroceryListProductDAO extends CrudRepository<GroceryListProduct, Long> {

    GroceryListProduct findOne(Long groceryListId);

    List<GroceryListProduct> findAll();

    List<GroceryListProduct> findByGroceryList(GroceryList groceryList);

    GroceryListProduct findByProductAndGroceryList(Product product, GroceryList groceryList);


}
