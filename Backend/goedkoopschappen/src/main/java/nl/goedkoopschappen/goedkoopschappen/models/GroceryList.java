package nl.goedkoopschappen.goedkoopschappen.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @OneToMany(mappedBy = "groceryList")
    @JsonIgnore
    private Set<GroceryListProduct> groceryListProducts;


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

    public Set<GroceryListProduct> getGroceryListProducts() {
        return groceryListProducts;
    }

    public void setGroceryListProducts(Set<GroceryListProduct> groceryListProducts) {
        this.groceryListProducts = groceryListProducts;
    }
}
