package com.tangyechun.model;

public class Book {
    private Integer id;

    private String bookname;

    private String isbn;

    private Double price;

    private String category;

    public Book(Integer id, String bookname, String isbn, Double price, String category) {
        this.id = id;
        this.bookname = bookname;
        this.isbn = isbn;
        this.price = price;
        this.category = category;
    }

    public Book() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname == null ? null : bookname.trim();
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn == null ? null : isbn.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }
}