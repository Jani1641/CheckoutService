package com.EcommWeb.CheckoutService.entities;

import javax.persistence.*;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
public class Orders {
    @Id
    @GeneratedValue
    private Integer orderId;

    private float amount;
    @Past
    private Date date;
    @Size(max = 50)
    private String address;
    @Size(max = 10)
    private String status;

    private Integer cartId;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    @OneToMany(mappedBy = "orders",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Details> detailsSet;

    public Orders() {
    }

    public Orders(float amount, Date date, String address, String status, Integer cartId) {
        this.amount = amount;
        this.date = date;
        this.address = address;
        this.status = status;
        this.cartId = cartId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Details> getDetailsSet() {
        return detailsSet;
    }

    public void setDetailsSet(List<Details> detailsSet) {
        this.detailsSet = detailsSet;
    }
}
