package com.thinkxfactor.springdemo.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IssuanceDto {
    private Long id;
    private Student student;
    private Book book;
    private String issueDate;
    private String approveDate;
    private boolean approved;
}
