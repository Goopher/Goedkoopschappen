package nl.goedkoopschappen.goedkoopschappen.services;

import nl.goedkoopschappen.goedkoopschappen.dao.IProductDAO;
import nl.goedkoopschappen.goedkoopschappen.models.Product;
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
                Iterator<Product> i = productList.iterator();
        while (i.hasNext()) {
            Product p = i.next(); // must be called before you can call i.remove()
            // Do something
            if (p.getProductName().matches("(.*)?([a-zA-Z0-9À-ÿ])(?i)"+searchString+"(?i)([a-zA-Z0-9À-ÿ])?(.*)?")) {
                i.remove();
                //System.out.println(p.getProductName()+" removed");
            }

        }

        return productList;
    }
}
