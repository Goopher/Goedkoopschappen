package nl.goedkoopschappen.goedkoopschappen.controller;


import nl.goedkoopschappen.goedkoopschappen.models.Product;
import nl.goedkoopschappen.goedkoopschappen.repositories.ProductRepository;

import nl.goedkoopschappen.goedkoopschappen.services.IProductService;
import nl.goedkoopschappen.goedkoopschappen.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.List;


@RestController
@CrossOrigin(origins = "http://loacalhost:4200")
public class ProductRestController {


    @Autowired
    private IProductService iProductService;


    @RequestMapping(value = "/products", params = "productName")
    @ResponseBody
    public List<Product> home (@RequestParam(value = "productName")String searchString){

        return iProductService.findByProductNameContaining(searchString);
    }




}
