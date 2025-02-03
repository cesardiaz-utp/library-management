package com.devsenior.cdiaz.library.repository.impl;

import java.util.ArrayList;
import java.util.List;

import com.devsenior.cdiaz.library.exceptions.NotFoundException;
import com.devsenior.cdiaz.library.model.Book;
import com.devsenior.cdiaz.library.repository.BookRepository;

public class MemoryBookRepository implements BookRepository {
    List<Book> books = new ArrayList<>();

    @Override
    public Book findById(Integer id) {
        Book response = null;

        for (var book : books) {
            if(book.getId().equals(id)){
                response = book;
                break;
            }
        }

        if(response == null){
            throw new NotFoundException("Libro no encontrado");
        }

        return response;
    }

    @Override
    public void save(Book book) {
        books.add(book);
    }
    
}
