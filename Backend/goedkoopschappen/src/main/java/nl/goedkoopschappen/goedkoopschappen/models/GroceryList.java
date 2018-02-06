package nl.goedkoopschappen.goedkoopschappen.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class GroceryList implements Serializable {

    @Id
    @GeneratedValue
    private Long groceryListId;

    @OneToMany
    private List<Product> groceryListItems;

    public GroceryList() {
    }

    public Long getGroceryListId() {
        return groceryListId;
    }

    public void setGroceryListId(Long groceryListId) {
        this.groceryListId = groceryListId;
    }

    public List<Product> getGroceryListItems() {
        return groceryListItems;
    }

    public void setGroceryListItems(List<Product> groceryListItems) {
        this.groceryListItems = groceryListItems;
    }
}
