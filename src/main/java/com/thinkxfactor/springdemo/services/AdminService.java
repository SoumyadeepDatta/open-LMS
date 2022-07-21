package com.thinkxfactor.springdemo.services;

import java.util.Set;

import com.thinkxfactor.springdemo.entities.Admin;
import com.thinkxfactor.springdemo.entities.LoginDto;

public interface AdminService {
    
    Admin save(Admin admin);

    Admin fetch(Long id);

    Set<Admin> fetchAll();

    void delete(Long id);

    Admin loginCheck(LoginDto loginDTO);
}
