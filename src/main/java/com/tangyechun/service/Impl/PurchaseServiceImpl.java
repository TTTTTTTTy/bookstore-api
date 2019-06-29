package com.tangyechun.service.Impl;

import com.tangyechun.mapper.PurchaseMapper;
import com.tangyechun.model.Purchase;
import com.tangyechun.model.PurchaseExample;
import com.tangyechun.service.PurchaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 * @since 2019/6/27 20:14
 */

@Service
public class PurchaseServiceImpl implements PurchaseService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PurchaseServiceImpl.class);

    @Autowired
    PurchaseMapper purchaseMapper;

    @Override
    public void addPurchase(Purchase purchase) {
        purchase.setDate(new Date());
        purchaseMapper.insertSelective(purchase);
    }

    @Override
    public int updatePurchase(Purchase purchase) {
        return purchaseMapper.updateByPrimaryKeySelective(purchase);
    }

    @Override
    public int deletePurchase(Integer purchaseId) {
        return purchaseMapper.deleteByPrimaryKey(purchaseId);
    }

    @Override
    public List<Purchase> getPurchase(String username) {
        PurchaseExample purchaseExample = new PurchaseExample();
        purchaseExample.createCriteria().andUsernameEqualTo(username);
        return purchaseMapper.selectByExample(purchaseExample);
    }

    @Override
    public List<Purchase> getAllPurchase() {
        return purchaseMapper.selectWithQq();
    }
}
