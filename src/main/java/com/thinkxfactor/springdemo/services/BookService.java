package com.thinkxfactor.springdemo.services;

import java.util.Set;

import com.thinkxfactor.springdemo.entities.Book;

public interface BookService {

    Book save(Book book);

    Book update(Book book);

    Book fetch(Long id);

    Set<Book> fetchAll();

    void delete(Long id);

    
}
