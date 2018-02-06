package nl.goedkoopschappen.goedkoopschappen.services;

import nl.goedkoopschappen.goedkoopschappen.dao.IGroceryListDAO;
import nl.goedkoopschappen.goedkoopschappen.dao.IProductDAO;
import nl.goedkoopschappen.goedkoopschappen.models.GroceryListItem;
import nl.goedkoopschappen.goedkoopschappen.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroceryListService implements IGroceryListService{

    @Autowired
    IGroceryListDAO iGroceryListDAO;

    @Autowired
    private IProductDAO iProductDAO;

    @Override
    public void create(GroceryListItem groceryListItem) {
        this.iGroceryListDAO.save(groceryListItem);
    }

    @Override
    public List<Product> findAll() {
        List<GroceryListItem> groceryList = this.iGroceryListDAO.findAll();
        List<Product> productList = new ArrayList<>();
        for(GroceryListItem item : groceryList){
            productList.add(iProductDAO.findByProductId(item.getProductId()));
        }
        return productList;
    }

}
