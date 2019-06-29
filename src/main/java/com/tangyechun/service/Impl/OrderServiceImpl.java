package com.tangyechun.service.Impl;

import com.tangyechun.common.ServiceException;
import com.tangyechun.common.StateCode;
import com.tangyechun.mapper.OrderMapper;
import com.tangyechun.model.Book;
import com.tangyechun.model.Order;
import com.tangyechun.model.OrderExample;
import com.tangyechun.model.UserBook;
import com.tangyechun.service.BookService;
import com.tangyechun.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 * @since 2019/6/27 0:37
 */

@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    BookService bookService;

    @Override
    @Transactional
    public void createOrder(Order order) {
        UserBook userBook = bookService.getUserBook(order.getUserBookId());
        if (userBook.getState()) {
            LOGGER.error("书籍重复购买");
            throw new ServiceException(StateCode.BOOK_SOLD_OUT.value(), StateCode.BOOK_SOLD_OUT.getReasonChPhrase());
        }
        userBook.setState(true);
        bookService.updateUserBook(userBook);
        Book book = bookService.getBook(userBook.getBookid());
        book.setNumber(book.getNumber() - 1);
        bookService.updateBook(book);
        if (book.getNumber() < 0) {
            LOGGER.error("书籍库存量小于0，bookId：{}", book.getId());
            throw new ServiceException("书籍库存量小于0!");
        }
        order.setState((byte) 0);
        order.setCreateDate(new Date());
        if (!order.getMode()) {  // '线下交易' 模式
            order.setAddress(null);
        }
        orderMapper.insertSelective(order);
    }

    @Override
    public List<Order> getOrderByBuyer(String username) {
//        OrderExample orderExample = new OrderExample();
//        orderExample.createCriteria().andBuyerNameEqualTo(username);
//        return orderMapper.selectByExample(orderExample);
        return orderMapper.selectByBuyer(username);
    }

    @Override
    public List<Order> getOrderBySeller(String username) {
//        OrderExample orderExample = new OrderExample();
//        orderExample.createCriteria().andSellerNameEqualTo(username);
//        return orderMapper.selectByExample(orderExample);
        return orderMapper.selectBySeller(username);
    }

    @Override
    public int ConfirmOrderBySeller(Integer orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        order.setState((byte) 1);
        return orderMapper.updateByPrimaryKey(order);
    }

    @Override
    public int ConfirmOrderByBuyer(Integer orderId) {
        Order order = orderMapper.selectByPrimaryKey(orderId);
        order.setState((byte) 2);
        order.setFinishDate(new Date());
        return orderMapper.updateByPrimaryKey(order);
    }
}
