package com.thinkxfactor.springdemo.services;

import java.util.Set;

import com.thinkxfactor.springdemo.models.Book;

public interface BookService {

    Book save(Book book);

    Book update(Book book);

    Book fetch(Long id);

    Set<Book> fetchAll();

    void delete(Long id);

    
}
