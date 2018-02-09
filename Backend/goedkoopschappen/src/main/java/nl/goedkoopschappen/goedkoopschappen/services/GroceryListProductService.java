package nl.goedkoopschappen.goedkoopschappen.services;

import nl.goedkoopschappen.goedkoopschappen.dao.IGroceryListProductDAO;
import nl.goedkoopschappen.goedkoopschappen.models.GroceryList;
import nl.goedkoopschappen.goedkoopschappen.models.GroceryListProduct;
import nl.goedkoopschappen.goedkoopschappen.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroceryListProductService implements IGroceryListProductService {

    @Autowired
    private IGroceryListProductDAO iGroceryListProductDAO;

    @Override
    public void create(GroceryListProduct groceryListProduct) {  this.iGroceryListProductDAO.save(groceryListProduct);}

    @Override
    public List<GroceryListProduct> findAll() { return this.iGroceryListProductDAO.findAll();}

    @Override
    public GroceryListProduct findOne(Long groceryListId, Long productId) {
        return null;
    }

    @Override
    public GroceryListProduct findByProductAndGroceryList(Product product, GroceryList groceryList) {
        return iGroceryListProductDAO.findByProductAndGroceryList(product, groceryList);
    }
}
