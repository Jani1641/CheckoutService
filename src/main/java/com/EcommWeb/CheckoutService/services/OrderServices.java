package com.EcommWeb.CheckoutService.services;

import com.EcommWeb.CheckoutService.Exceptions.ResourceNotFoundException;
import com.EcommWeb.CheckoutService.entities.Details;
import com.EcommWeb.CheckoutService.entities.Orders;
import com.EcommWeb.CheckoutService.models.CartDetailResponse;
import com.EcommWeb.CheckoutService.models.CartOrderResponse;
import com.EcommWeb.CheckoutService.models.CartResponse;
import com.EcommWeb.CheckoutService.repository.DetailsRepository;
import com.EcommWeb.CheckoutService.repository.OrdersRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;


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

    public CartResponse getCartResponse(Integer order_id){
        log.info("Started getCartResponse function from OrderServices");
        String URL = CARTORDER_URL + Integer.toString(order_id);
        CartResponse cartResponse = restTemplate.getForEntity(URL,CartResponse.class).getBody();
        log.info("End of getCartResponse function from OrderServices");
        return cartResponse;
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

    public void saveCartResponse(CartResponse cartResponse,Integer order_id,String address){
        log.info("Started saveCartResponse function from OrderServices");
        Orders order=ordersRepository.findByCartId(order_id);
        if(order!=null){
            throw new ResourceNotFoundException("it is already present");
        }
        Orders orders = new Orders(cartResponse.getAmount(),new Date(),address,"Placed",cartResponse.getCartId());
        ordersRepository.save(orders);
        CartDetailConverter cartDetailConverter = new CartDetailConverter();
        List<CartDetailResponse> itemsList =cartResponse.getItems();
        for (CartDetailResponse x: itemsList){
            Details detailsEntity = cartDetailConverter.convertCartDetailResponseToDetails(x,ordersRepository.findByCartId(order_id));
            detailsRepository.save(detailsEntity);
        }
        log.info("End of saveCartResponse function from OrderServices");
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
