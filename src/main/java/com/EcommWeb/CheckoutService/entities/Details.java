package com.EcommWeb.CheckoutService.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

@Entity
public class Details {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer itemId;
    @Column(name = "quantity")
    private Integer quantity;
    private String imageUrl;
    private String title;
    private float price;
    @ManyToOne
    @JsonIgnoreProperties(value = {"detailsSet","handler","hibernateLazyInitializer"})
    @JoinColumn(name = "order_id",referencedColumnName = "orderId")
    private Orders orders;

    public Details(Integer itemId, Integer quantity, String imageUrl, String title, float price, Orders orders) {
        this.itemId = itemId;
        this.quantity = quantity;
        this.imageUrl = imageUrl;
        this.title = title;
        this.price = price;
        this.orders = orders;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Details() {
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
}
