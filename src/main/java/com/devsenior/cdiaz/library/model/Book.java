package com.devsenior.cdiaz.library.model;

public class Book {
    private Integer id;
    private String title;
    private String author;
    
    public Book(Integer id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }   
}
