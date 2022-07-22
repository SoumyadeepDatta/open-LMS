package com.thinkxfactor.springdemo.services.impls;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkxfactor.springdemo.entities.Admin;
import com.thinkxfactor.springdemo.entities.LoginDto;
import com.thinkxfactor.springdemo.repository.AdminRepository;
import com.thinkxfactor.springdemo.services.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

    @Autowired
    AdminRepository adminRepo;

    @Override
    public Admin save(Admin admin) {
        return this.adminRepo.save(admin);
    }

    @Override
    public Admin fetch(Long id) {
        return (this.adminRepo.existsById(id))? (
            this.adminRepo.findById(id).get()
        ) : null;
    }

    @Override
    public Set<Admin> fetchAll() {
        return new HashSet<>(
            this.adminRepo.findAll()
        );
    }

    @Override
    public void delete(Long id) {
        this.adminRepo.deleteById(id);
        
    }

    @Override
    public Admin loginCheck(LoginDto loginDTO) {
        Optional<Admin> admin = this.adminRepo.findByUsernameAndPassword(loginDTO.getUsername(), loginDTO.getPassword());
        return (admin.isPresent())? admin.get():null; 
    }
    
}
