package com.devsenior.cdiaz.library.repository;

import com.devsenior.cdiaz.library.model.Book;

public interface BookRepository {
    Book findById(Integer id);

    void save(Book book);
}
