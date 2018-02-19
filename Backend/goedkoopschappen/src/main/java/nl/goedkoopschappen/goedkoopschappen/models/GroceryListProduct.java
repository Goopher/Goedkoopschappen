package nl.goedkoopschappen.goedkoopschappen.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class GroceryListProduct implements Serializable {

    @Id
    @GeneratedValue
    private Long groceryListProductId;

    @ManyToOne
    @JoinColumn(name = "grocery_list_id")
    private GroceryList groceryList;


    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column
    private Integer amount;


    public Long getGroceryListProductId() {
        return groceryListProductId;
    }

    public void setGroceryListProductId(Long groceryListProductId) {
        this.groceryListProductId = groceryListProductId;
    }

    public GroceryList getGroceryList() {
        return groceryList;
    }

    public void setGroceryList(GroceryList groceryList) {
        this.groceryList = groceryList;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
