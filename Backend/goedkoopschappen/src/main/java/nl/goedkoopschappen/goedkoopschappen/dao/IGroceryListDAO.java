package nl.goedkoopschappen.goedkoopschappen.dao;

import nl.goedkoopschappen.goedkoopschappen.models.GroceryList;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IGroceryListDAO extends CrudRepository<GroceryList, Long>{
    List<GroceryList> findAll();

}
