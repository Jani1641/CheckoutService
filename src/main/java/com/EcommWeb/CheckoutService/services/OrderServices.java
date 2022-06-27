package com.EcommWeb.CheckoutService.services;

import com.EcommWeb.CheckoutService.Exceptions.ResourceNotFoundException;
import com.EcommWeb.CheckoutService.entities.Details;
import com.EcommWeb.CheckoutService.entities.Orders;
import com.EcommWeb.CheckoutService.models.CartDetailResponse;
import com.EcommWeb.CheckoutService.models.CartOrderResponse;
import com.EcommWeb.CheckoutService.repository.DetailsRepository;
import com.EcommWeb.CheckoutService.repository.OrdersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;


@Slf4j
@Service
public class OrderServices {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrdersRepository ordersRepository;

    @Autowired
    private DetailsRepository detailsRepository;
    private final String CARTORDER_URL ="http://localhost:8082/carts/";

    public CartOrderResponse getCartDetailsService(Integer order_id){
        log.info("Started getCartDetailsService function from OrderServices");
        String URL = CARTORDER_URL + Integer.toString(order_id);
        CartOrderResponse body = restTemplate.getForEntity(URL, CartOrderResponse.class).getBody();
        log.info("Started getCartDetailsService function from OrderServices");
        return body;
    }
    public CartDetailResponse[] getItemsListService(Integer order_id){
        log.info("Started getItemsListService function from OrderServices");
        String URL = CARTORDER_URL + Integer.toString(order_id)+"/details";
        CartDetailResponse[] body = restTemplate.getForEntity(URL, CartDetailResponse[].class).getBody();
        log.info("End of getItemsListService function from OrderServices");
        return body;
    }
    public Orders saveOrdersService(CartOrderResponse cartDetail){
        log.info("Started saveOrdersService function from OrderServices");
        Orders orders = new Orders(cartDetail.getAmount(),new Date(),cartDetail.getAddress(),"Placed",cartDetail.getCartId());
        ordersRepository.save(orders);
        log.info("End of saveOrdersService function from OrderServices");
        return orders;
    }
    public void saveDetailsService(CartDetailResponse[] itemsList, Integer order_id){
        log.info("Started saveDetailsService function from OrdersService");
        CartDetailConverter cartDetailConverter = new CartDetailConverter();
        for (CartDetailResponse x: itemsList){
            Details detailsEntity = cartDetailConverter.convertCartDetailResponseToDetails(x,ordersRepository.findByCartId(order_id));
            detailsRepository.save(detailsEntity);
        }
        log.info("Started saveDetailsService function from OrdersService");
    }
    public void deleteOrderPlacedService(Integer order_id){
        log.info("Started deleteOrderPlacedService function from OrderService");
        Orders orders = ordersRepository.findByCartId(order_id);
        if(orders == null){
            throw new ResourceNotFoundException("id "+order_id+" is not found.");
        }
        ordersRepository.deleteById(orders.getOrderId());
        log.info("End of deleteOrderPlacedService function from OrderService");
    }

    public void updateOrder(String status,Integer id){
        log.info("Started updateOrder function from OrderService");
        Orders orders = ordersRepository.findByCartId(id);
        if(orders == null){
            throw new ResourceNotFoundException("Cart with "+ Integer.toString(id)+" is not found");
        }
        orders.setStatus(status);
        ordersRepository.save(orders);
        log.info("End of updateOrder function from OrderService");
    }
}
