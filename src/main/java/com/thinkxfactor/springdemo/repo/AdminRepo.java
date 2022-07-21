package com.thinkxfactor.springdemo.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.thinkxfactor.springdemo.entities.Admin;

public interface AdminRepo extends JpaRepository<Admin,Long>{
    
    Optional<Admin> findByUsernameAndPassword(String username, String password);
}
