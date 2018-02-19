package nl.goedkoopschappen.goedkoopschappen.dao;

import nl.goedkoopschappen.goedkoopschappen.models.GroceryList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGroceryListDAO extends CrudRepository<GroceryList, Long>{
    List<GroceryList> findAll();


    @Override
    GroceryList findOne(Long id);
}
