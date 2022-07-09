package com.thinkxfactor.springdemo.APIs;

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

import com.thinkxfactor.springdemo.models.Admin;
import com.thinkxfactor.springdemo.models.LoginDTO;
import com.thinkxfactor.springdemo.services.AdminService;

@RestController
@RequestMapping("/admin")
@CrossOrigin
public class AdminAPI {

    @Autowired
    AdminService adminService;

    @PostMapping("/register")
    public ResponseEntity<?> create(@RequestBody Admin admin) {
        return ResponseEntity.ok(this.adminService.save(admin));
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginCheck(@RequestBody LoginDTO loginDTO) {
        return (this.adminService.loginCheck(loginDTO)==null)? 
            ResponseEntity.status(HttpStatus.NOT_FOUND).build():
            ResponseEntity.ok(this.adminService.loginCheck(loginDTO));
    }

    @GetMapping("/fetchAll")
    public ResponseEntity<?> fetchAll() {
        return (this.adminService.fetchAll().isEmpty())? 
            ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
            ResponseEntity.ok(this.adminService.fetchAll()
            ); 
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<?> fetch(@PathVariable Long id) {
        return (this.adminService.fetch(id) == null)?
            ResponseEntity.status(HttpStatus.NOT_FOUND).build() :
            new ResponseEntity<>(this.adminService.fetch(id), HttpStatus.FOUND);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Admin admin){
        return ResponseEntity.ok(this.adminService.save(admin));
    }
}
