package com.thinkxfactor.springdemo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.thinkxfactor.springdemo.entities.Issuance;

public interface IssuanceRepo extends JpaRepository<Issuance, Long>{

    Optional<Issuance> findBySidAndBid(Long sid,Long bid);
    
    // return all books for a student with id == sid
    @Query("SELECT isu.bid FROM Issuance isu where isu.sid = :SID")
    List<Optional<Long>> findBySid(@Param("SID") Long SID);

    @Query("SELECT isu FROM Issuance isu where isu.sid = :SID")
    List<Optional<Issuance>> findIssuanceBySid(@Param("SID") Long SID);

    // return all student ids
    @Query("SELECT isu.sid FROM Issuance isu")
    List<Optional<Long>> findAllSid();

    @Query("SELECT isu.sid FROM Issuance isu where isu.bid = :BID")
    List<Optional<Long>> findByBid(@Param("BID") Long BID);

    // two extra annotations are required for DML queries
    @Modifying
    @Transactional
    @Query("DELETE FROM Issuance isu WHERE isu.sid = :SID AND isu.bid = :BID")
    void deleteBySidAndBid(@Param("SID") Long SID, @Param("BID") Long BID);

    @Modifying
    @Transactional
    @Query("DELETE FROM Issuance isu WHERE isu.bid = :BID")
    void deleteByBid(@Param("BID") Long BID);


    @Modifying
    @Transactional
    @Query("UPDATE Issuance isu SET isu.approved=TRUE, isu.dateTimeOfApproval= :DATE WHERE isu.sid = :SID AND isu.bid = :BID")
    void approveIssuance(@Param("SID") Long SID, @Param("BID") Long BID, @Param("DATE") String DATE);

}
