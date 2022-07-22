package com.thinkxfactor.springdemo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thinkxfactor.springdemo.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByUsernameAndPassword(String username, String password);
}
