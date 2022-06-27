package com.EcommWeb.CheckoutService.models;

public class DetailsResponse {
    private Integer item_id;
    private Integer quantity;
    private DetailsResponse(DetailsResponseBuilder detailsResponseBuilder){
        this.item_id = detailsResponseBuilder.item_id;
        this.quantity = detailsResponseBuilder.quantity;
    }

    public static class DetailsResponseBuilder{
        private Integer item_id;
        private Integer quantity;

        public DetailsResponseBuilder item_id(Integer item_id){
            this.item_id=item_id;
            return this;
        }

        public DetailsResponseBuilder quantity(Integer quantity){
            this.quantity = quantity;
            return this;
        }

        public DetailsResponse build(){
            DetailsResponse response = new DetailsResponse(this);
            return response;
        }
    }

    public Integer getItem_id() {
        return item_id;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
