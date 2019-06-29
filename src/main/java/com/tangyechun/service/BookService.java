package com.tangyechun.service;

import com.tangyechun.common.ServiceException;
import com.tangyechun.model.Book;
import com.tangyechun.model.UserBook;

import java.util.List;

/**
 * @author Administrator
 * @since 2019/6/21 22:
 */
public interface BookService {

    Book SearchOnInternet(String isbn) throws ServiceException;

    void addBook(String isbn, int category) throws ServiceException;

    void addUserBook(String isbn, String username, double price, String description, String image);

    int updateBook(Book book);

    Book getBook(Integer id);

    List<Book> getBookLike(String bookName);

    List<Book> getBooks(int kind);

    List<UserBook> getUserBooks(String username);

    List<UserBook> getUserBooks(Integer bookId);

    UserBook getUserBook(Integer id);

    int updateUserBook(UserBook userBook);

    int deleteUserBook(Integer id);

}
