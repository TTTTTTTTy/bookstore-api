package com.tangyechun.controller;

import com.tangyechun.bean.RespBean;
import com.tangyechun.common.ServiceException;
import com.tangyechun.common.StateCode;
import com.tangyechun.model.Order;
import com.tangyechun.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Administrator
 * @since 2019/6/27 0:42
 */

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    @ResponseBody
    public RespBean addOrder(Order order) {
        try {
            orderService.createOrder(order);
            return RespBean.ok("订单创建成功");
        } catch (ServiceException e) {
            return RespBean.error("订单创建失败," + e.getMessage());
        }
    }

    @GetMapping(value = "/buyer/{username}")
    @ResponseBody
    public List<Order> getOrderByBuyer(@PathVariable String username) {
        return orderService.getOrderByBuyer(username);
    }

    @GetMapping(value = "/seller/{username}")
    @ResponseBody
    public List<Order> getOrderBySeller(@PathVariable String username) {
        return orderService.getOrderBySeller(username);
    }

    @RequestMapping(value = "/seller/{orderId}", method = RequestMethod.PUT)
    @ResponseBody
    public RespBean ConfirmOrderBySeller(@PathVariable Integer orderId) {
        if (orderService.ConfirmOrderBySeller(orderId) == 1) {
            return RespBean.ok("确认订单成功!");
        }
        return RespBean.error("确认订单失败!");
    }

    @RequestMapping(value = "/buyer/{orderId}", method = RequestMethod.PUT)
    @ResponseBody
    public RespBean ConfirmOrderByBuyer(@PathVariable Integer orderId) {
        if (orderService.ConfirmOrderByBuyer(orderId) == 1) {
            return RespBean.ok("确认订单成功!");
        }
        return RespBean.error("确认订单失败!");
    }

}
