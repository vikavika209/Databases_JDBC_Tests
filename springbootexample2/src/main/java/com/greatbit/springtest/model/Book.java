package com.greatbit.springtest.model;

public class Book {
    private String id;
    private int pages;
    private String name;
    private String author;


    public Book(String id, int pages, String name, String author) {
        this.id = id;
        this.pages = pages;
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPages() {
        return pages;
    }
}
