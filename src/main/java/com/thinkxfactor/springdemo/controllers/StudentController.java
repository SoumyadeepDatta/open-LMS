package com.thinkxfactor.springdemo.controllers;

import com.thinkxfactor.springdemo.entities.LoginDto;
import com.thinkxfactor.springdemo.entities.Student;
import com.thinkxfactor.springdemo.services.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
@CrossOrigin
public class StudentController {
    
    @Autowired
    private StudentService studentService;

    @PostMapping("/register")
    public ResponseEntity<?> create(@RequestBody Student student) {
        return ResponseEntity.ok(this.studentService.save(student));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginCheck(@RequestBody LoginDto loginDTO) {
        return (this.studentService.loginCheck(loginDTO)==null)? 
            ResponseEntity.status(HttpStatus.NOT_FOUND).build():
            ResponseEntity.ok(this.studentService.loginCheck(loginDTO));
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<?> fetchAll() {
        return (this.studentService.fetchAll().isEmpty())? 
            ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
            ResponseEntity.ok(this.studentService.fetchAll()
            ); 
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<?> fetch(@PathVariable Long id) {
        return (this.studentService.fetch(id) == null)?
            ResponseEntity.status(HttpStatus.NOT_FOUND).build() :
            new ResponseEntity<>(this.studentService.fetch(id), HttpStatus.FOUND);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Student student) {
        return ResponseEntity.ok(this.studentService.save(student));
    }

}
