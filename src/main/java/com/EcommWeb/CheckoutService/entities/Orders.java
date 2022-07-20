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
    @Size(max = 10)
    private String status;
    private Integer cartId;
    @Column(unique = true)
    private String address;
    private String email;
    @OneToMany(mappedBy = "orders",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Details> details;

    public Orders() {
    }

    public Orders(float amount, Date date, String status, Integer cartId, String address, String email) {
        this.amount = amount;
        this.date = date;
        this.status = status;
        this.cartId = cartId;
        this.address = address;
        this.email = email;
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

    public List<Details> getDetails() {
        return details;
    }

    public void setDetailsSet(List<Details> details) {
        this.details = details;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

}
