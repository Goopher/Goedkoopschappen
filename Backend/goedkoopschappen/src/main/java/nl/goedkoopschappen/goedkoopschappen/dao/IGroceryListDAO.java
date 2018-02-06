package nl.goedkoopschappen.goedkoopschappen.dao;

import nl.goedkoopschappen.goedkoopschappen.models.GroceryListItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IGroceryListDAO extends CrudRepository<GroceryListItem, Long>{
    List<GroceryListItem> findAll();

}
