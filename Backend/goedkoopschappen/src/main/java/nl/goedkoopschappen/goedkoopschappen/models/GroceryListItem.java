package nl.goedkoopschappen.goedkoopschappen.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity(name="grocery_list")
public class GroceryListItem {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private Long productId;


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }
}
