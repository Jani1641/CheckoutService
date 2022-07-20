package com.EcommWeb.CheckoutService.services;

import com.EcommWeb.CheckoutService.entities.Orders;
import com.EcommWeb.CheckoutService.models.DetailsResponse;
import com.EcommWeb.CheckoutService.models.OrdersResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderConverter {
    public OrdersResponse convertOrderToOrderResponse(Orders orders){
        DetailConverter detailConverter = new DetailConverter();
        List<DetailsResponse> detailsResponses = orders.getDetails().stream().map(detailConverter::convertDetailsToDetailsResponse).collect(Collectors.toList());
        OrdersResponse response = new OrdersResponse.OrdersResponseBuilder()
                .address(orders.getAddress())
                .amount(orders.getAmount())
                .date(orders.getDate())
                .status(orders.getStatus())
                .detailsResponse(detailsResponses)
                .build();
        return response;
    }

}
