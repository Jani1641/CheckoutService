package com.EcommWeb.CheckoutService.models;

import java.util.List;

public class CartResponse {

    private Integer cartId;
    private float amount;
    private List<CartDetailResponse> items;

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public CartResponse() {}

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public List<CartDetailResponse> getItems() {
        return items;
    }

    public void setItems(List<CartDetailResponse> items) {
        this.items = items;
    }
    private CartResponse(CartResponseBuilder cartResponseBuilder){
        this.cartId=cartResponseBuilder.cartId;
        this.amount=cartResponseBuilder.amount;
        this.items = cartResponseBuilder.detailResponseList;
    }

    public static class CartResponseBuilder{
        private Integer cartId;
        private float amount;
        private List<CartDetailResponse> detailResponseList;
        public CartResponseBuilder cartId (Integer cartId){
            this.cartId = cartId;
            return this;
        }
        public CartResponseBuilder amount(float amount){
            this.amount = amount;
            return this;
        }
        public CartResponseBuilder detailList(List<CartDetailResponse> detailResponseList){
            this.detailResponseList= detailResponseList;
            return this;
        }
        public CartResponse build(){
            return new CartResponse(this);
        }
    }
}
