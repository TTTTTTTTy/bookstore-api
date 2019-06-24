package com.tangyechun.service.Impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tangyechun.common.CategoryCode;
import com.tangyechun.common.ServiceException;
import com.tangyechun.common.StateCode;
import com.tangyechun.mapper.BookMapper;
import com.tangyechun.mapper.UserBookMapper;
import com.tangyechun.model.Book;
import com.tangyechun.model.BookExample;
import com.tangyechun.model.UserBook;
import com.tangyechun.model.UserBookExample;
import com.tangyechun.service.BookService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 * @since 2019/6/21 22:15
 */

@Service
public class BookServiceImpl implements BookService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
    private static RestTemplate restTemplate;

    @Autowired
    BookMapper bookMapper;

    @Autowired
    UserBookMapper userBookMapper;

    static {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        restTemplate = new RestTemplate(requestFactory);
    }

    @Override
    public Book SearchOnInternet(String isbn) throws ServiceException {
        String url = "https://api.douban.com/v2/book/isbn/" + isbn + "?apikey=0b2bdeda43b5688921839c8ecb20399b";
        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(null, new HttpHeaders());
        JSONObject response = null;
        try {
            response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, JSONObject.class).getBody();
        } catch (Exception e) {
            LOGGER.error("获取书籍信息错误:{}", e.getMessage());
            if (e.getMessage().equals("404 Not Found")) {
                throw new ServiceException(StateCode.ISBN_NOT_FOUND.value(), StateCode.ISBN_NOT_FOUND.getReasonChPhrase());
            } else {
                throw new ServiceException(StateCode.UNKNOWN.value(), StateCode.UNKNOWN.getReasonChPhrase());
            }
        }
        Book book = new Book();
        JSONArray authors = response.getJSONArray("author");
        StringBuilder author = new StringBuilder();
        for (int i = 0; i < authors.size(); i++) {
            author.append(authors.getString(i));
            author.append(",");
        }
        if (author.length() != 0) {
            author.deleteCharAt(author.length() - 1);
        }
        book.setAuthor(author.toString());
        book.setBookname(response.getString("title") + response.getString("subtitle"));
        book.setImage(response.getString("image"));
        book.setPrice(response.getString("price"));
        book.setUrl(response.getString("alt"));
        String summary = response.getString("summary");
        if (summary.length() > 500) {
            summary = summary.substring(0, 500);
        }
        book.setSummary(summary);
        book.setIsbn(isbn);
        return book;
    }

    @Override
    public void addBook(String isbn, int category) throws ServiceException {
        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andIsbnEqualTo(isbn);
        List<Book> books = bookMapper.selectByExample(bookExample);
        Book book;
        if (books == null || books.size() == 0) {
            book = SearchOnInternet(isbn);
            if (book == null) {
                LOGGER.error("添加书籍失败: 获取书籍信息错误");
                throw new ServiceException("添加书籍失败: 获取书籍信息错误");
            }
            StringBuilder sb = new StringBuilder();
            sb.append(category);
            for (int i = 0; i < CategoryCode.values().length; i++) {
                sb.append(",");
                if (i == category) {
                    sb.append("1");
                } else {
                    sb.append("0");
                }
            }
            book.setCategory(sb.toString());
            book.setNumber(1);
            bookMapper.insert(book);
        } else {
            book = books.get(0);
            String[] olds = book.getCategory().split(",");
            int oldMax = Integer.parseInt(olds[Integer.parseInt(olds[0]) + 1]);
            int add = Integer.parseInt(olds[category + 1] + 1);
            String max = (oldMax >= add) ? olds[0] : String.valueOf(category);
            StringBuilder newCategory = new StringBuilder();
            newCategory.append(max);
            for (int i = 1; i < olds.length; i++) {
                newCategory.append(",");
                if (i != category + 1) {
                    newCategory.append(olds[i]);
                } else {
                    newCategory.append(add);
                }
            }
            book.setCategory(newCategory.toString());
            book.setNumber(book.getNumber() + 1);
            bookMapper.updateByExampleSelective(book, bookExample);
        }
    }

    @Override
    public void addUserBook(String isbn, String username, double price, String description, String image) {
        BookExample bookExample = new BookExample();
        bookExample.createCriteria().andIsbnEqualTo(isbn);
        List<Book> books = bookMapper.selectByExample(bookExample);
        int bookId = books.get(0).getId();
        UserBook userBook = new UserBook();
        userBook.setBookid(bookId);
        userBook.setUsername(username);
        userBook.setSellPrice(price);
        userBook.setDescription(description);
        userBook.setImage(image);
        userBook.setDate(new Date());
        userBook.setState(false);
        userBookMapper.insert(userBook);
    }


    @Override
    public Book getBook(String isbn) {
        return null;
    }

    @Override
    public List<UserBook> getUserBooks(String username) {
        return userBookMapper.selectByUser(username);
    }

    @Override
    public int updateUserBook(UserBook userBook) {
        UserBookExample userBookExample = new UserBookExample();
        userBookExample.createCriteria().andIdEqualTo(userBook.getId());
        return userBookMapper.updateByExampleSelective(userBook, userBookExample);
    }

    @Override
    public int deleteUserBook(Integer id) {
        return userBookMapper.deleteByPrimaryKey(id);
    }
}
