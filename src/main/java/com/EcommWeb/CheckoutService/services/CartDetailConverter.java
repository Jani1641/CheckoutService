package com.EcommWeb.CheckoutService.services;

import com.EcommWeb.CheckoutService.entities.Details;
import com.EcommWeb.CheckoutService.entities.Orders;
import com.EcommWeb.CheckoutService.models.CartDetailResponse;

public class CartDetailConverter {
    public Details convertCartDetailResponseToDetails (CartDetailResponse cartDetailResponse, Orders orders){
        Details details = new Details(cartDetailResponse.getId(),cartDetailResponse.getQuantity(),orders);
        return details;
    }
}
