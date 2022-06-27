package com.EcommWeb.CheckoutService.services;

import com.EcommWeb.CheckoutService.entities.Orders;
import com.EcommWeb.CheckoutService.models.OrdersResponse;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderConverter {
    public OrdersResponse convertOrderToOrderResponse(Orders orders){
        OrdersResponse response = new OrdersResponse.OrdersResponseBuilder()
                .address(orders.getAddress())
                .amount(orders.getAmount())
                .date(orders.getDate())
                .status(orders.getStatus())
                .build();
        return response;
    }

    public Orders convertOrderResponseToOrders(OrdersResponse ordersResponse, Integer order_id, Date date,String status){
        Orders orders = new Orders(ordersResponse.getAmount(),date,ordersResponse.getAddress(),status,order_id);
        return orders;
    }
}
