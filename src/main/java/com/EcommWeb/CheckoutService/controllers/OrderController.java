package com.EcommWeb.CheckoutService.controllers;

import com.EcommWeb.CheckoutService.models.AddressResponse;
import com.EcommWeb.CheckoutService.models.CartDetailResponse;
import com.EcommWeb.CheckoutService.models.CartOrderResponse;
import com.EcommWeb.CheckoutService.models.CartResponse;
import com.EcommWeb.CheckoutService.services.OrderServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@Slf4j
@RestController
public class OrderController {
    @Autowired
    private OrderServices orderServices;

    @PostMapping("/checkout/{order_id}/submit")
    public ResponseEntity<String> submitOrder (@PathVariable Integer order_id, @RequestBody AddressResponse addressResponse){
        log.info("Started submitOrder function in Controller");
        CartResponse cartResponse = orderServices.getCartResponse(order_id);
        orderServices.saveCartResponse(cartResponse,order_id,addressResponse.getAddress());
        log.info("End of submitOrder function in Controller");
        return new ResponseEntity<>("Created", HttpStatus.OK);
    }

    @DeleteMapping("/checkout/{order_id}")
    public ResponseEntity<Object> deleteOrder (@PathVariable Integer order_id){
        log.info("Started deleteOrder function in Controller");
        orderServices.deleteOrderPlacedService(order_id);
        log.info("End of deleteOrder function in Controller");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/checkout/{order_id}")
    public ResponseEntity<Object> updateOrder(@PathVariable Integer order_id ,@RequestParam String status){
        log.info("Started updateOrder function in Controller");
        orderServices.updateOrder(status,order_id);
        log.info("End of updateOrder function in Controller");
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
