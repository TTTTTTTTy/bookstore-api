package com.tangyechun.service;

import com.tangyechun.model.Order;

import java.util.List;

/**
 * @author Administrator
 * @since 2019/6/27 0:34
 */

public interface OrderService {

    void createOrder(Order order);

    List<Order> getOrderByBuyer(String username);

    List<Order> getOrderBySeller(String username);

    int ConfirmOrderBySeller(Integer orderId);

    int ConfirmOrderByBuyer(Integer orderId);


}
