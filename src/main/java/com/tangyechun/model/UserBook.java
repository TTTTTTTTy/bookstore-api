package com.tangyechun.model;

import java.util.Date;

public class UserBook {
    private Integer id;

    private String username;

    private Integer bookid;

    private Boolean state;

    private Double sellPrice;

    private String description;

    private String image;

    private Date date;

    private String bookname;

    private String qq;

    public UserBook(Integer id, String username, Integer bookid, Boolean state, Double sellPrice, String description, String image, Date date) {
        this.id = id;
        this.username = username;
        this.bookid = bookid;
        this.state = state;
        this.sellPrice = sellPrice;
        this.description = description;
        this.image = image;
        this.date = date;
    }

    public UserBook(Integer id, String username, Integer bookid, Boolean state, Double sellPrice, String description, String image, Date date, String bookname) {
        this.id = id;
        this.username = username;
        this.bookid = bookid;
        this.state = state;
        this.sellPrice = sellPrice;
        this.description = description;
        this.image = image;
        this.date = date;
        this.bookname = bookname;
    }

    public UserBook(Integer id, String username, Integer bookid, Boolean state, Double sellPrice, String description, String image, String qq, Date date) {
        this.id = id;
        this.username = username;
        this.bookid = bookid;
        this.state = state;
        this.sellPrice = sellPrice;
        this.description = description;
        this.image = image;
        this.date = date;
        this.qq = qq;
    }

    public UserBook() {
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

    public Integer getBookid() {
        return bookid;
    }

    public void setBookid(Integer bookid) {
        this.bookid = bookid;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }
}