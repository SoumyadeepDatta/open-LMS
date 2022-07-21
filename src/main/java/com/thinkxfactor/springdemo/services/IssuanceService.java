package com.thinkxfactor.springdemo.services;

import java.util.Set;

import com.thinkxfactor.springdemo.entities.Issuance;
import com.thinkxfactor.springdemo.entities.IssuanceDto;
import com.thinkxfactor.springdemo.entities.Student;

public interface IssuanceService {
    
    void issueBook(Long sid, Long bid);

    Set<IssuanceDto> getAllIssuanceDetails();

    Set<IssuanceDto> getIssuedBooks(Long sid);

    Set<Student> getStudentsWhoIssued(Long bid);

    boolean canIssue(Long sid, Long bid);

    void returnBook(Long sid,Long bid);

    Issuance findIssuanceBySidAndBid(Long sid,Long bid);

    void deleteIssuanceByBid(Long bid);

    void approveIssuance(Long sid,Long bid);
}
