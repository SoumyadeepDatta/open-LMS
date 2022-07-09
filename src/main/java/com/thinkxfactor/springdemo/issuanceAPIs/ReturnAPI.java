package com.thinkxfactor.springdemo.issuanceAPIs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.thinkxfactor.springdemo.libServices.IssuanceService;
import com.thinkxfactor.springdemo.mgr.BookQtyMgr;

@RestController
@RequestMapping("/return")
@CrossOrigin
public class ReturnAPI {
    
    @Autowired
    IssuanceService issuanceService;

    // @Autowired
    // URI_MGR uMgr;

    @Autowired
    BookQtyMgr bookQtyMgr;

    @DeleteMapping("/returnBook")
    public ResponseEntity<?> returnBook(@RequestParam Long sid,@RequestParam Long bid){
        this.issuanceService.returnBook(sid, bid);
        return ResponseEntity.ok("");
    }

    // // 1. return books
    // @DeleteMapping("/returnBooks")
    // public ResponseEntity<?> returnBooks(@RequestParam Long sid, @RequestBody List<Long> bidList) {

    //     // check existence of student
    //     if(!studentRepository.existsById(sid)) {
    //         return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    //     }
    //     else {
    //         // check existence of books
    //         Set<Long> bidSet = new HashSet<>(bidList);
    //         for(Long bid : bidSet) {
    //             if(!bookRepository.existsById(bid)) {
    //                 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    //             }
    //         }

    //         // handle -ve qty (if any)
    //         bookQtyMgr.handleNegQty();

    //         // perform actions

    //         for(Long bid : bidSet) {
                
    //             borrowRepository.deleteBySidAndBid(sid, bid);

    //             // after returning the book increment its qty by 1
    //             bookQtyMgr.bookQtyInc(bid);
    //         }

    //         return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    //     }
    // }

    // // 2. show books to return (redirect to similar method /borrow/borrowedBooks)
    // @GetMapping("/booksToReturn")
    // public ResponseEntity<?> booksToReturn(@RequestParam Long sid) {
    //     return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(uMgr.BASE_URL + "/borrow/borrowedBooks?sid=" + sid)).build();
    // }

}
