package com.tangyechun.controller;

import com.tangyechun.bean.RespBean;
import com.tangyechun.model.Purchase;
import com.tangyechun.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Administrator
 * @since 2019/6/27 23:55
 */

@Controller
@RequestMapping("/purchase")
public class PurchaseController {

    @Autowired
    PurchaseService purchaseService;

    @PostMapping
    @ResponseBody
    public RespBean addPurchase(Purchase purchase) {
        purchaseService.addPurchase(purchase);
        return RespBean.ok("发布成功");
    }

    @GetMapping(value = "/{username}")
    @ResponseBody
    public List<Purchase> getPurchase(@PathVariable(value = "username") String username) {
        return purchaseService.getPurchase(username);
    }

    @GetMapping
    @ResponseBody
    public List<Purchase> getAllPurchase() {
        return purchaseService.getAllPurchase();
    }

    @PutMapping
    @ResponseBody
    public RespBean updatePurchase(Purchase purchase) {
        if (purchaseService.updatePurchase(purchase) == 1) {
            return RespBean.ok("编辑成功");
        }
        return RespBean.ok("编辑失败");
    }

    @DeleteMapping(value = "/{id}")
    @ResponseBody
    public RespBean deletePurchase(@PathVariable(value = "id") Integer id) {
        if (purchaseService.deletePurchase(id) == 1) {
            return RespBean.ok("删除成功");
        }
        return RespBean.ok("删除失败");
    }


}
