package com.EcommWeb.CheckoutService.repository;

import com.EcommWeb.CheckoutService.entities.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
public interface OrdersRepository extends JpaRepository<Orders,Integer> {

    @Query("SELECT order FROM Orders order where order.cartId = ?1 ")
    Orders findByCartId(Integer cartId);

    @Query("SELECT order FROM Orders order where order.email = ?1 ")
    List<Orders> findByEmail(String email);
}
