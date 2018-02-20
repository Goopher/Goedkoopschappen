package nl.goedkoopschappen.goedkoopschappen.dao;

import nl.goedkoopschappen.goedkoopschappen.models.GroceryList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGroceryListDAO extends CrudRepository<GroceryList, Long>{
    @Override
    List<GroceryList> findAll();

    @Override
    void delete(Long id);

    @Override
    GroceryList findOne(Long id);
}
