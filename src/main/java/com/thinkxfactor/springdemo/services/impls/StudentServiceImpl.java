package com.thinkxfactor.springdemo.services.impls;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkxfactor.springdemo.entities.LoginDto;
import com.thinkxfactor.springdemo.entities.Student;
import com.thinkxfactor.springdemo.repo.StudentRepo;
import com.thinkxfactor.springdemo.services.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    StudentRepo studentRepo;

    @Override
    public Student save(Student student) {
        return this.studentRepo.save(student);
    }

    @Override
    public Student fetch(Long id) {
        return (this.studentRepo.existsById(id))? (
            this.studentRepo.findById(id).get()
        ) : null;
    }

    @Override
    public Set<Student> fetchAll() {
        return new HashSet<>(
            this.studentRepo.findAll()
        );
    }

    @Override
    public void delete(Long id) {
        this.studentRepo.deleteById(id);
    }

    @Override
    public Student loginCheck(LoginDto loginDTO) {
        Optional<Student> student = this.studentRepo.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());
        return (student.isPresent())? student.get():null; 
    }
    
}
