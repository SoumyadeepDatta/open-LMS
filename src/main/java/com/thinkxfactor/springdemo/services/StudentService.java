package com.thinkxfactor.springdemo.services;

import java.util.Set;

import com.thinkxfactor.springdemo.models.LoginDTO;
import com.thinkxfactor.springdemo.models.Student;


public interface StudentService {
    
    Student save(Student student);

    Student fetch(Long id);

    Set<Student> fetchAll();

    void delete(Long id);

    Student loginCheck(LoginDTO loginDTO);
}
