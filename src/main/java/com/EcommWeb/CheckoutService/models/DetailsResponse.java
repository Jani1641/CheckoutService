package com.EcommWeb.CheckoutService.models;

public class DetailsResponse {
    private Integer item_id;
    private Integer quantity;
    private String imageUrl;
    private String title;
    private float price;

    private DetailsResponse(DetailsResponseBuilder detailsResponseBuilder){
        this.item_id = detailsResponseBuilder.item_id;
        this.quantity = detailsResponseBuilder.quantity;
        this.imageUrl = detailsResponseBuilder.imageUrl;
        this.title = detailsResponseBuilder.title;
        this.price = detailsResponseBuilder.price;
    }

    public static class DetailsResponseBuilder{
        private Integer item_id;
        private Integer quantity;
        private String imageUrl;
        private String title;
        private float price;

        public DetailsResponseBuilder item_id(Integer item_id){
            this.item_id=item_id;
            return this;
        }

        public DetailsResponseBuilder quantity(Integer quantity){
            this.quantity = quantity;
            return this;
        }

        public DetailsResponseBuilder imageUrl(String imageUrl){
            this.imageUrl = imageUrl;
            return this;
        }

        public DetailsResponseBuilder title(String title){
            this.title = title;
            return this;
        }

        public DetailsResponseBuilder price (float price){
            this.price = price;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public float getPrice() {
        return price;
    }
}
