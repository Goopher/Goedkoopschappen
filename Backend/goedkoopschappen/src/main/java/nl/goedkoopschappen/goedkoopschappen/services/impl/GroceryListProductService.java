package nl.goedkoopschappen.goedkoopschappen.services.impl;

import nl.goedkoopschappen.goedkoopschappen.dao.IGroceryListProductDAO;
import nl.goedkoopschappen.goedkoopschappen.models.GroceryList;
import nl.goedkoopschappen.goedkoopschappen.models.GroceryListProduct;
import nl.goedkoopschappen.goedkoopschappen.models.Product;
import nl.goedkoopschappen.goedkoopschappen.services.IGroceryListProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class    GroceryListProductService implements IGroceryListProductService {

    @Autowired
    private IGroceryListProductDAO iGroceryListProductDAO;

    @Override
    public GroceryListProduct create(GroceryListProduct groceryListProduct) {  return this.iGroceryListProductDAO.save(groceryListProduct);}

    @Override
    public List<GroceryListProduct> findAll() { return this.iGroceryListProductDAO.findAll();}

    @Override
    public List<GroceryListProduct> findByGroceryList(GroceryList groceryList){ return iGroceryListProductDAO.findByGroceryList(groceryList);}

    @Override
    public GroceryListProduct findOne(Long groceryListId) {
        return iGroceryListProductDAO.findOne(groceryListId);
    }

    @Override
    public GroceryListProduct findByProductAndGroceryList(Product product, GroceryList groceryList) {
        return iGroceryListProductDAO.findByProductAndGroceryList(product, groceryList);
    }

    @Override
    public void delete(Long id) {
        iGroceryListProductDAO.delete(id);
    }
}
