package com.tangyechun.model;

public class Order {
    private Integer id;

    private Byte state;

    private Integer userBookId;

    private Integer buyerId;

    private Boolean delivery;

    public Order(Integer id, Byte state, Integer userBookId, Integer buyerId, Boolean delivery) {
        this.id = id;
        this.state = state;
        this.userBookId = userBookId;
        this.buyerId = buyerId;
        this.delivery = delivery;
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

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Integer getUserBookId() {
        return userBookId;
    }

    public void setUserBookId(Integer userBookId) {
        this.userBookId = userBookId;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    public Boolean getDelivery() {
        return delivery;
    }

    public void setDelivery(Boolean delivery) {
        this.delivery = delivery;
    }
}