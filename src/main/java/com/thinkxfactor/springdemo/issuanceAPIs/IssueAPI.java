package com.thinkxfactor.springdemo.issuanceAPIs;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thinkxfactor.springdemo.libAction.Issuance;
import com.thinkxfactor.springdemo.libServices.IssuanceService;

@RestController
@RequestMapping("/issuance")
@CrossOrigin
public class IssueAPI {

    @Autowired
    IssuanceService issuanceService;

    @PostMapping("/issueBook")
    public ResponseEntity<?> issueBook(@RequestBody Issuance i) {

        issuanceService.issueBook(i.getSid(), i.getBid());
        return ResponseEntity.ok("");
    }

    @PostMapping("/canIssue")
    public ResponseEntity<?> canIssue(@RequestBody Issuance i) {
        
        return ResponseEntity.ok(this.issuanceService.canIssue(i.getSid(), i.getBid()));
    }

    @GetMapping("/allIssuanceDetails")
    public ResponseEntity<?> getAllissuanceDetails() {

        return ResponseEntity.ok(this.issuanceService.getAllIssuanceDetails());
    }

    @GetMapping("/issuedBooks/{sid}")
    public ResponseEntity<?> getIssuedBooks(@PathVariable Long sid) {
        return ResponseEntity.ok(this.issuanceService.getIssuedBooks(sid));
    }

    @GetMapping("/issuedBy/{bid}")
    public ResponseEntity<?> getissuanceedBy(@PathVariable Long bid) {
        return new ResponseEntity<>(issuanceService.getStudentsWhoIssued(bid),
                (issuanceService.getStudentsWhoIssued(bid).size() == 0) ? HttpStatus.NO_CONTENT : HttpStatus.FOUND);
    }

    @GetMapping("/findIssuance")
    public ResponseEntity<?> findBySidAndBid(@RequestParam Long sid,@RequestParam Long bid){
        return ResponseEntity.ok(this.issuanceService.findIssuanceBySidAndBid(sid, bid));
    }

    @PutMapping("/approve")
    public ResponseEntity<?> approveIssuance(@RequestBody Issuance i){
        this.issuanceService.approveIssuance(i.getSid(), i.getBid());
        return ResponseEntity.ok("");
    }

}
