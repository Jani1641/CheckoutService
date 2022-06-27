package com.EcommWeb.CheckoutService.repository;

import com.EcommWeb.CheckoutService.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.criteria.CriteriaBuilder;

public interface OrdersRepository extends JpaRepository<Orders,Integer> {

    @Query("SELECT order FROM Orders order where order.cartId = ?1 ")
    Orders findByCartId(Integer cartId);


}
