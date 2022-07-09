package com.thinkxfactor.springdemo.libServices;

import java.util.Set;

import com.thinkxfactor.springdemo.libAction.Issuance;
import com.thinkxfactor.springdemo.libAction.IssuanceResponse;
import com.thinkxfactor.springdemo.models.Student;

public interface IssuanceService {
    
    void issueBook(Long sid, Long bid);

    Set<IssuanceResponse> getAllIssuanceDetails();

    Set<IssuanceResponse> getIssuedBooks(Long sid);

    Set<Student> getStudentsWhoIssued(Long bid);

    boolean canIssue(Long sid, Long bid);

    void returnBook(Long sid,Long bid);

    Issuance findIssuanceBySidAndBid(Long sid,Long bid);

    void deleteIssuanceByBid(Long bid);

    void approveIssuance(Long sid,Long bid);
}
