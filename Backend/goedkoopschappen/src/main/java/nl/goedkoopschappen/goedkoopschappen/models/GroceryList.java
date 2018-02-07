package nl.goedkoopschappen.goedkoopschappen.models;

import javax.persistence.*;
import java.util.List;


@Entity(name="grocery_lists")
public class GroceryList {

    @Id
    @GeneratedValue
    private Long groceryListId;

    @Column
    private String creationDate;

    @ManyToMany
    private List<Product> productList;

    public Long getGroceryListId() {
        return groceryListId;
    }

    public void setGroceryListId(Long groceryListId) {
        this.groceryListId = groceryListId;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

}