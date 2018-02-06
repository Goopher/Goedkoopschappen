package nl.goedkoopschappen.goedkoopschappen.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity(name="jumboproducts")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;

    @Column
    private String productName;
    @Column
    private String brandName;
    @Column(columnDefinition = "Text")
    private String description;
    @Column
    private int price;
    @Column
    private int houseBrand;
    @Column
    private String productUrl;
    @Column
    private String imageUrl;


    /*    @Column
    private int amount;*/

    public Product () {

    }


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }


/*    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }*/
    public int getHouseBrand() {
        return houseBrand;
    }

    public void setHouseBrand(int houseBrand) {
        this.houseBrand = houseBrand;
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    @Override
    public String toString() {
        String houseBrand = "";
        if(this.houseBrand == 0) {
            houseBrand = "Huismerk: ja";
        } else {
            houseBrand = "Huismerk: nee";
        }
        return this.productName + ", " + this.brandName + ", " + this.description + ", " + houseBrand + ", " + price;
    }
}
