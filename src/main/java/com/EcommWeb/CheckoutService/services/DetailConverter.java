package com.EcommWeb.CheckoutService.services;

import com.EcommWeb.CheckoutService.entities.Details;
import com.EcommWeb.CheckoutService.entities.Orders;
import com.EcommWeb.CheckoutService.models.DetailsResponse;

public class DetailConverter {
    public DetailsResponse convertDetailsToDetailsResponse (Details details){
        DetailsResponse response = new DetailsResponse.DetailsResponseBuilder()
                .item_id(details.getItemId())
                .quantity(details.getQuantity())
                .build();
        return response;
    }

    public Details convertDetailsResponseToDetails (DetailsResponse detailsResponse, Orders orders){
        Details details = new Details(detailsResponse.getItem_id(),detailsResponse.getQuantity(),orders);
        return details;
    }
}
