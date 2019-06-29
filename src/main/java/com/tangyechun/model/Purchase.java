package com.tangyechun.model;

import java.util.Date;

public class Purchase {
    private Integer id;

    private String username;

    private String bookname;

    private Date date;

    private Double price;

    private String description;

    private String qq;

    public Purchase(Integer id, String username, String bookname, Date date, Double price, String description) {
        this.id = id;
        this.username = username;
        this.bookname = bookname;
        this.date = date;
        this.price = price;
        this.description = description;
    }

    public Purchase(Integer id, String username, String bookname, Date date, Double price, String description, String qq) {
        this.id = id;
        this.username = username;
        this.bookname = bookname;
        this.date = date;
        this.price = price;
        this.description = description;
        this.qq = qq;
    }

    public Purchase() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname == null ? null : bookname.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }
}