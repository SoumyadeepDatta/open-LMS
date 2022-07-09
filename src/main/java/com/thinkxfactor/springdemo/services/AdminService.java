package com.thinkxfactor.springdemo.services;

import java.util.Set;

import com.thinkxfactor.springdemo.models.Admin;
import com.thinkxfactor.springdemo.models.LoginDTO;

public interface AdminService {
    
    Admin save(Admin admin);

    Admin fetch(Long id);

    Set<Admin> fetchAll();

    void delete(Long id);

    Admin loginCheck(LoginDTO loginDTO);
}
