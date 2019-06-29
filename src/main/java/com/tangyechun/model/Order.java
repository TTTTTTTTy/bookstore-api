package com.tangyechun.model;

import java.util.Date;

public class Order {
    private Integer id;

    private Integer userBookId;

    private String bookname;

    private String buyerName;

    private String sellerName;

    private String phone;

    private Double price;

    private Boolean mode;

    private Byte state;

    private Date createDate;

    private Date finishDate;

    private String address;

    private String qq;

    public Order(Integer id, Integer userBookId, String bookname, String buyerName, String sellerName, String phone, Double price, Boolean mode, Byte state, Date createDate, Date finishDate, String address) {
        this.id = id;
        this.userBookId = userBookId;
        this.bookname = bookname;
        this.buyerName = buyerName;
        this.sellerName = sellerName;
        this.phone = phone;
        this.price = price;
        this.mode = mode;
        this.state = state;
        this.createDate = createDate;
        this.finishDate = finishDate;
        this.address = address;
    }

    public Order(Integer id, Integer userBookId, String bookname, String buyerName, String sellerName, String phone, Double price, Boolean mode, Byte state, Date createDate, Date finishDate, String address, String qq) {
        this.id = id;
        this.userBookId = userBookId;
        this.bookname = bookname;
        this.buyerName = buyerName;
        this.sellerName = sellerName;
        this.phone = phone;
        this.price = price;
        this.mode = mode;
        this.state = state;
        this.createDate = createDate;
        this.finishDate = finishDate;
        this.address = address;
        this.qq = qq;
    }

    public Order() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserBookId() {
        return userBookId;
    }

    public void setUserBookId(Integer userBookId) {
        this.userBookId = userBookId;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname == null ? null : bookname.trim();
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName == null ? null : buyerName.trim();
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName == null ? null : sellerName.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getMode() {
        return mode;
    }

    public void setMode(Boolean mode) {
        this.mode = mode;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }
}