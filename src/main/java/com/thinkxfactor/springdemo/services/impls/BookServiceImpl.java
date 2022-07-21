package com.thinkxfactor.springdemo.services.impls;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkxfactor.springdemo.entities.Book;
import com.thinkxfactor.springdemo.repo.BookRepo;
import com.thinkxfactor.springdemo.services.BookService;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepo bookRepo;
    
    @Override
    public Book save(Book book) {
        return this.bookRepo.save(book);
    }

    @Override
    public Book fetch(Long id) {
        return (this.bookRepo.existsById(id))? (
            this.bookRepo.findById(id).get()
        ) : null;
    }

    @Override
    public Set<Book> fetchAll() {
        return new HashSet<>(
            this.bookRepo.findAll()
        );
    }

    @Override
    public void delete(Long id) {
        this.bookRepo.deleteById(id);
    }

    @Override
    public Book update(Book book) {
        return this.bookRepo.save(book);
    }
    
}
