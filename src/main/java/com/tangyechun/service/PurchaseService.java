package com.tangyechun.service;

import com.tangyechun.model.Purchase;

import java.util.List;

/**
 * @author Administrator
 * @since 2019/6/27 20:13
 */
public interface PurchaseService {

    void addPurchase(Purchase purchase);

    int updatePurchase(Purchase purchase);

    int deletePurchase(Integer purchaseId);

    List<Purchase> getPurchase(String username);

    List<Purchase> getAllPurchase();

}
