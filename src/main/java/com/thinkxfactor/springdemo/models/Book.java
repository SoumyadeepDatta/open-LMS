package com.thinkxfactor.springdemo.models;

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
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private Long isbn;

    private Integer qty=0;

    @Column(nullable = false)
    private String name;

    

}
