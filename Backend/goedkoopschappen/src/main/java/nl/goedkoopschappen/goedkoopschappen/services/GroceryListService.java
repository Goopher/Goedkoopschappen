package nl.goedkoopschappen.goedkoopschappen.services;

import nl.goedkoopschappen.goedkoopschappen.dao.IGroceryListDAO;
import nl.goedkoopschappen.goedkoopschappen.dao.IProductDAO;
import nl.goedkoopschappen.goedkoopschappen.models.GroceryList;
import nl.goedkoopschappen.goedkoopschappen.models.GroceryListProduct;
import nl.goedkoopschappen.goedkoopschappen.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroceryListService implements IGroceryListService{

    @Autowired
    private IGroceryListDAO iGroceryListDAO;

    @Override
    public GroceryList create(GroceryList groceryList) {
       return this.iGroceryListDAO.save(groceryList);
    }

    @Override
    public List<GroceryList> findAll() { return this.iGroceryListDAO.findAll();}

    public GroceryList findOne(Long id) {
        return iGroceryListDAO.findOne(id);
    }

}
