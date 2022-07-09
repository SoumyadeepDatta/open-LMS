package com.thinkxfactor.springdemo.APIs;

import com.thinkxfactor.springdemo.libServices.IssuanceService;
import com.thinkxfactor.springdemo.models.Book;
import com.thinkxfactor.springdemo.services.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
@CrossOrigin()
public class BookAPI {

    @Autowired
    private BookService bookService;

    @Autowired
    private IssuanceService issuanceService;

    @PostMapping("/add")
    public ResponseEntity<?> create(@RequestBody Book book) {
        return ResponseEntity.ok(
                this.bookService.save(book));
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Book book) {
        return ResponseEntity.ok(
                this.bookService.update(book));
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<?> readAll() {
        return (this.bookService.fetchAll().size() == 0) ? 
            ResponseEntity.status(HttpStatus.NO_CONTENT).build() : 
            ResponseEntity.ok(this.bookService.fetchAll()
            );
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<?> readById(@PathVariable Long id) {
        return (this.bookService.fetch(id) == null) ? 
            ResponseEntity.status(HttpStatus.NO_CONTENT).build() : 
            ResponseEntity.ok(
                this.bookService.fetch(id)
            );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBookById(@PathVariable Long id){
        this.bookService.delete(id);
        this.issuanceService.deleteIssuanceByBid(id);
        return ResponseEntity.ok("");
    }
}
