package nl.goedkoopschappen.goedkoopschappen.models;

import javax.persistence.*;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;


@Entity(name="grocery_lists")
public class GroceryList {

    @Id
    @GeneratedValue
    private Long groceryListId;

    @Column
    private String groceryListName;

    @Column
    private Timestamp timestamp;

    @ManyToMany
    @JoinTable(
            name = "grocery_list_product",
            joinColumns = {@JoinColumn(name="grocery_list_id")},
            inverseJoinColumns = {@JoinColumn(name="product_id")}
    )
    private List<Product> productList;

    public Long getGroceryListId() {
        return groceryListId;
    }

    public void setGroceryListId(Long groceryListId) {
        this.groceryListId = groceryListId;
    }

    public String getGroceryListName() {
        return groceryListName;
    }

    public void setGroceryListName(String groceryListName) {
        this.groceryListName = groceryListName;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

}
