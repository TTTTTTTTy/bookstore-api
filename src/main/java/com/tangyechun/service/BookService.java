package com.tangyechun.service;

import com.tangyechun.common.ServiceException;
import com.tangyechun.model.Book;

/**
 * @author Administrator
 * @since 2019/6/21 22:
 */
public interface BookService {

    Book SearchOnInternet(String isbn) throws ServiceException;

    void addBook(String isbn, int category) throws ServiceException;

    void addUserBook(String isbn, String username, double price, String description, String image);

    Book getBook(String isbn);

}
