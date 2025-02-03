package com.devsenior.cdiaz.library.service;

import java.time.LocalDate;
import java.util.List;

import com.devsenior.cdiaz.library.model.Book;
import com.devsenior.cdiaz.library.model.Loan;
import com.devsenior.cdiaz.library.model.User;
import com.devsenior.cdiaz.library.repository.BookRepository;
import com.devsenior.cdiaz.library.repository.LoanRepository;

public class LibraryService {
    private BookRepository bookRepository;
    private LoanRepository loanRepository;

    public LibraryService(BookRepository bookRepository, LoanRepository loanRepository) {
        this.bookRepository = bookRepository;
        this.loanRepository = loanRepository;
    }

    public Book getBook(int id) {
        return bookRepository.findById(id);
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void loanBook(User user, Book book) {
        Loan loan = new Loan(1, user, book, LocalDate.now());
        loanRepository.save(loan);
    }

    public List<Loan> getLoansByUser(User user) {
        return loanRepository.findByUser(user);
    }
}
