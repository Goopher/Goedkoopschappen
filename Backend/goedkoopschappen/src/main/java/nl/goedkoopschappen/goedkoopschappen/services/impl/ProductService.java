package nl.goedkoopschappen.goedkoopschappen.services.impl;

import nl.goedkoopschappen.goedkoopschappen.dao.IProductDAO;
import nl.goedkoopschappen.goedkoopschappen.models.Product;
import nl.goedkoopschappen.goedkoopschappen.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@Service("productService")
public class ProductService implements IProductService {

    @Autowired
    private IProductDAO iProductDAO;

    @Override
    public void create(Product product) {
        this.iProductDAO.save(product);
    }

    @Override
    public List<Product> findAll() {
        return this.iProductDAO.findAll();
    }

    @Override
    public Product findByProductId(Long productId){return this.iProductDAO.findByProductId(productId);}

    @Override
    public List<Product> findByProductNameContaining(String searchString) {
        List<Product> productList = this.iProductDAO.findByProductNameContainingOrderByPriceAsc(searchString);

        productList.removeIf(p -> p.getProductName().matches(
                "(.*)?([a-zA-Z0-9À-ÿ])(?i)" + searchString + "(?i)([a-zA-Z0-9À-ÿ])?(.*)?"
        ));

        productList.removeIf(p -> p.getPrice()<=0);

        return productList;
    }
}
