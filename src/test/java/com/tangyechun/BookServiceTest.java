package com.tangyechun;

import com.tangyechun.common.ServiceException;
import com.tangyechun.model.UserBook;
import com.tangyechun.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author Administrator
 * @since 2019/6/18 18:22
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTest {

    @Autowired
    BookService bookService;

    @Test
    public void test() {
        System.err.println(System.getProperty("user.dir") + "\\images");
    }

    @Test
    public void search() throws ServiceException {
        bookService.SearchOnInternet("9787115417305");
    }

    @Test
    public void addBook() throws ServiceException {
        bookService.addBook("9787569925159", 11);
    }

    @Test
    public void addUserBook() throws ServiceException {
        bookService.addUserBook("9787302517979", "admin", 16.5, "", "1");
    }

    @Test
    public void getUserBooks() {
        List<UserBook> userBookList = bookService.getUserBooks("admin");
        System.err.println(userBookList.size());
    }

}