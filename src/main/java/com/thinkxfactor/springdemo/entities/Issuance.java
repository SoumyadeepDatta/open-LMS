package com.thinkxfactor.springdemo.entities;


import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class Issuance {
    
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Long sid;

    @Column(nullable = false)
    private Long bid;

    @Column(nullable = false)
    private boolean approved;

    private String dateTimeOfIssue;

    private String dateTimeOfApproval;

    
    public Issuance(Long sid, Long bid) {
        this.sid = sid;
        this.bid = bid;
        
        this.approved=false;

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
    	Date date = new Date();

        this.dateTimeOfIssue = formatter.format(date);
    }

    

}
