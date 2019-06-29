package com.tangyechun;

import com.tangyechun.model.Purchase;
import com.tangyechun.service.OrderService;
import com.tangyechun.service.PurchaseService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author Administrator
 * @since 2019/6/27 19:55
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {

    @Autowired
    OrderService orderService;

    @Autowired
    PurchaseService purchaseService;

    @Test
    public void test() {

        purchaseService.getAllPurchase();
    }

}
