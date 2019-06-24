package com.tangyechun.controller;

import com.tangyechun.bean.RespBean;
import com.tangyechun.common.ServiceException;
import com.tangyechun.common.StateCode;
import com.tangyechun.model.Book;
import com.tangyechun.model.UserBook;
import com.tangyechun.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/update")
    @ResponseBody
    public RespBean updateUserBook(Integer id, Double sellPrice, String description, String imageUrl) {
        UserBook userBook = new UserBook();
        userBook.setId(id);
        userBook.setSellPrice(sellPrice);
        userBook.setDescription(description);
        userBook.setImage(imageUrl);
        if (bookService.updateUserBook(userBook) == 1) {
            return RespBean.ok("编辑成功!");
        } else {
            return RespBean.error("编辑失败!");
        }
    }

    @RequestMapping(value = "/userbook/{username}", method = RequestMethod.GET)
    @ResponseBody
    public List<UserBook> getUserBook(@PathVariable(value = "username") String username) {
        return bookService.getUserBooks(username);
    }

    @RequestMapping(value = "/userbook/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public RespBean deleteSalary(@PathVariable Integer id) {
        if (bookService.deleteUserBook(id) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }
}
