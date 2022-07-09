package com.thinkxfactor.springdemo.libAction;


import com.thinkxfactor.springdemo.models.Book;
import com.thinkxfactor.springdemo.models.Student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IssuanceResponse {
    private Long id;
    private Student student;
    private Book book;
    private String issueDate;
    private String approveDate;
    private boolean approved;
}
