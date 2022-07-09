package com.thinkxfactor.springdemo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thinkxfactor.springdemo.models.Student;

public interface StudentRepo extends JpaRepository<Student, Long> {

    Optional<Student> findByUsernameAndPassword(String username, String password);
}
