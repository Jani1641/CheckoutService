package com.EcommWeb.CheckoutService.models;

import java.util.Date;
import java.util.List;

public class OrdersResponse {
    private float amount;
    private String address;
    private String status;
    private Date date;

    private List<DetailsResponse> detailsResponse;

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<DetailsResponse> getDetailsResponse() {
        return detailsResponse;
    }

    public void setDetailsResponse(List<DetailsResponse> detailsResponse) {
        this.detailsResponse = detailsResponse;
    }

    private OrdersResponse(OrdersResponseBuilder ordersResponseBuilder){
        this.amount = ordersResponseBuilder.amount;
        this.address = ordersResponseBuilder.address;
        this.status = ordersResponseBuilder.status;
        this.date = ordersResponseBuilder.date;
        this.detailsResponse=ordersResponseBuilder.detailsResponses;
    }
    public static class OrdersResponseBuilder{
        private float amount;
        private String address;
        private String status;
        private Date date;
        private List<DetailsResponse> detailsResponses;

        public OrdersResponseBuilder amount(float amount){
            this.amount = amount;
            return this;
        }

        public OrdersResponseBuilder address(String address){
            this.address = address;
            return this;
        }
        public OrdersResponseBuilder status(String status){
            this.status = status;
            return this;
        }
        public OrdersResponseBuilder date(Date date){
            this.date = date;
            return this;
        }
        public OrdersResponseBuilder detailsResponse(List<DetailsResponse> detailsResponses){
            this.detailsResponses=detailsResponses;
            return this;
        }
        public OrdersResponse build(){
            return new OrdersResponse(this);
        }

    }
}
