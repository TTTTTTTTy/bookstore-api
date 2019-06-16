package com.tangyechun.model;

public class UserBook {
    private Integer id;

    private String username;

    private Integer bookid;

    private Byte state;

    public UserBook(Integer id, String username, Integer bookid, Byte state) {
        this.id = id;
        this.username = username;
        this.bookid = bookid;
        this.state = state;
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

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }
}