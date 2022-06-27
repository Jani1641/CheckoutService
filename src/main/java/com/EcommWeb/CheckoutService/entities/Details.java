package com.EcommWeb.CheckoutService.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;

@Entity
public class Details {
    @Id
    @GeneratedValue
    private Integer id;

    private Integer itemId;

    private Integer quantity;

    @ManyToOne
    @JsonIgnoreProperties(value = {"detailsSet","handler","hibernateLazyInitializer"})
    @JoinColumn(name = "order_id",referencedColumnName = "orderId")
    private Orders orders;

    public Details(Integer itemId, Integer quantity, Orders orders) {
        this.itemId = itemId;
        this.quantity = quantity;
        this.orders = orders;
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
