package com.devsenior.cdiaz.library.model;

import java.time.LocalDate;

public class Loan {
    private Integer id;
    private User user;
    private Book book;
    private LocalDate loanDate;

    public Loan(User user, Book book) {
        this(1, user, book, LocalDate.now());
    }

    public Loan(Integer id, User user, Book book, LocalDate loanDate) {
        this.id = id;
        this.user = user;
        this.book = book;
        this.loanDate = loanDate;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

}
