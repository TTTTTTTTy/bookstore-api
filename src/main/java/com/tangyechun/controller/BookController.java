package com.tangyechun.controller;

import com.tangyechun.bean.RespBean;
import com.tangyechun.common.ServiceException;
import com.tangyechun.common.StateCode;
import com.tangyechun.model.Book;
import com.tangyechun.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author Administrator
 * @since 2019/6/22 1:21
 */

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/search/{ISBN}", method = RequestMethod.GET)
    @ResponseBody
    public RespBean getBook(@PathVariable(value = "ISBN") String ISBN) {
        try {
            Book book = bookService.SearchOnInternet(ISBN);
            if (book == null) {
                return RespBean.error(StateCode.UNKNOWN.getReasonChPhrase());
            }
            return RespBean.ok("查询成功", book);
        } catch (ServiceException e) {
            if (e.getErrorCode() == StateCode.ISBN_NOT_FOUND.value()) {
                return RespBean.error(StateCode.ISBN_NOT_FOUND.getReasonChPhrase());
            } else {
                return RespBean.error(StateCode.UNKNOWN.getReasonChPhrase());
            }
        }
    }

    @PostMapping("/add")
    @ResponseBody
    public RespBean addBook(String ISBN, String category, String username, String sellPrice,
                            String description, String imageUrl) {
        try {
            bookService.addBook(ISBN, Integer.parseInt(category));
            bookService.addUserBook(ISBN, username, Double.parseDouble(sellPrice), description, imageUrl);
            return RespBean.ok("上传成功");
        } catch (ServiceException e) {
            return RespBean.error("上传失败！系统内部错误，请联系管理员");
        }
    }
}
