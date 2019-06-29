package com.tangyechun.model;

public class Book {
    private Integer id;

    private String bookname;

    private String isbn;

    private String author;

    private String price;

    private String category;

    private String url;

    private String image;

    private Integer number;

    private String summary;

    private Byte kind;

    public Book(Integer id, String bookname, String isbn, String author, String price, String category, String url, String image, Integer number, String summary, Byte kind) {
        this.id = id;
        this.bookname = bookname;
        this.isbn = isbn;
        this.author = author;
        this.price = price;
        this.category = category;
        this.url = url;
        this.image = image;
        this.number = number;
        this.summary = summary;
        this.kind = kind;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image == null ? null : image.trim();
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public Byte getKind() {
        return kind;
    }

    public void setKind(Byte kind) {
        this.kind = kind;
    }
}