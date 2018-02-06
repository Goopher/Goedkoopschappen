package nl.goedkoopschappen.goedkoopschappen.controller;


import nl.goedkoopschappen.goedkoopschappen.models.Product;
import nl.goedkoopschappen.goedkoopschappen.repositories.IProductRepository;

import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
>>>>>>> master
import java.util.List;


@RestController
public class ProductRestController {


    @Autowired
    private IProductService iProductService;


    @RequestMapping(value = "/products", params = "productName")
    @ResponseBody
    public List<Product> home (@RequestParam(value = "productName")String searchString){

        return iProductService.findByProductNameContaining(searchString);
    }
>>>>>>> master


}
