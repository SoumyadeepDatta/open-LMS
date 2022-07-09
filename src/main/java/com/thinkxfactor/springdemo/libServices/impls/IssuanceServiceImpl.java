package com.thinkxfactor.springdemo.libServices.impls;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkxfactor.springdemo.libAction.Issuance;
import com.thinkxfactor.springdemo.libAction.IssuanceResponse;
import com.thinkxfactor.springdemo.libServices.IssuanceService;
import com.thinkxfactor.springdemo.mgr.BookQtyMgr;
import com.thinkxfactor.springdemo.models.Book;
import com.thinkxfactor.springdemo.models.Student;
import com.thinkxfactor.springdemo.repo.BookRepo;
import com.thinkxfactor.springdemo.repo.IssuanceRepo;
import com.thinkxfactor.springdemo.repo.StudentRepo;

@Service
public class IssuanceServiceImpl implements IssuanceService {

        @Autowired
        private StudentRepo studentRepo;

        @Autowired
        private BookRepo bookRepo;

        @Autowired
        private IssuanceRepo issuanceRepo;

        @Autowired
        private BookQtyMgr bookQtyMgr;

        // @Override
        // public void issueBooks(Long sid, Set<Long> bids) {

        // if (studentRepo.existsById(sid) && // check if student exists
        // bids.stream()
        // .allMatch(id -> {
        // return bookRepo.existsById(id)
        // && bookQtyMgr.getBookQty(id) != null
        // && bookQtyMgr.getBookQty(id) > 0;
        // }) // check if books exists
        // ) {
        // if (!issuanceRepo.findBySid(sid).stream()
        // .anyMatch(
        // o -> bids.contains(o.get()) // check if some wanted book already
        // // taken
        // )) {
        // bids.stream()
        // .forEach(
        // bid -> {
        // issuanceRepo.save(new Issuance(sid, bid));
        // bookQtyMgr.bookQtyDec(bid);
        // } // TODO add bookqtymgr here
        // );
        // }
        // }
        // }

        @Override
        public void issueBook(Long sid, Long bid) {
                if (this.studentRepo.existsById(sid) && this.bookRepo.existsById(bid)) {
                        Set<Long> bidSet = this.issuanceRepo.findBySid(sid).stream().map(o -> o.get())
                                        .collect(Collectors.toSet());
                        if (!bidSet.contains(bid) && this.bookQtyMgr.getBookQty(bid) > 0) {
                                this.issuanceRepo.save(new Issuance(sid,bid));
                                bookQtyMgr.bookQtyDec(bid);
                        }
                }
        }

        @Override
        public Set<IssuanceResponse> getAllIssuanceDetails() {



                Set<IssuanceResponse> records = new HashSet<>();

                this.issuanceRepo.findAll().stream().forEach(e->{
                        Student student = this.studentRepo.findById(e.getSid()).get();
                        Book book = this.bookRepo.findById(e.getBid()).get();
                        records.add(new IssuanceResponse(e.getId(), student, book, e.getDateTimeOfIssue(), e.getDateTimeOfApproval(), e.isApproved()));
                });


                // this.issuanceRepo.findAllSid().stream().forEach(e -> {
                //         Student student = this.studentRepo.findById(e.get()).get();
                //         Set<Book> books = this.issuanceRepo.findBySid(e.get()).stream()
                //                         .map(x -> this.bookRepo.findById(x.get()).get()).collect(Collectors.toSet());
                //         records.add(new IssuanceResponse(student, books,));
                // });
                return records;
        }

        @Override
        public Set<IssuanceResponse> getIssuedBooks(Long sid) {
                return this.issuanceRepo.findIssuanceBySid(sid).stream().map(o->{
                        Student student = this.studentRepo.findById(o.get().getSid()).get();
                        Book book = this.bookRepo.findById(o.get().getBid()).get();
                        return new IssuanceResponse(o.get().getId(), student, book, o.get().getDateTimeOfIssue(), o.get().getDateTimeOfApproval(), o.get().isApproved());
                }).collect(Collectors.toSet());
        }

        @Override
        public Set<Student> getStudentsWhoIssued(Long bid) {
                return issuanceRepo.findByBid(bid).stream()
                                .map(
                                                o -> studentRepo.findById(o.get()).get())
                                .collect(Collectors.toSet());
        }

        @Override
        public boolean canIssue(Long sid, Long bid) {
                if (this.studentRepo.existsById(sid) && this.bookRepo.existsById(bid)) {
                        Set<Long> bidSet = this.issuanceRepo.findBySid(sid).stream().map(o -> o.get())
                                        .collect(Collectors.toSet());
                        if (!bidSet.contains(bid) && this.bookQtyMgr.getBookQty(bid) > 0) {
                                return true;
                        }
                }
                return false;
        }

        @Override
        public void returnBook(Long sid, Long bid) {
                if(this.issuanceRepo.findBySidAndBid(sid, bid).isPresent()){
                        this.issuanceRepo.deleteBySidAndBid(sid, bid);
                        this.bookQtyMgr.bookQtyInc(bid);
                }
        }

        @Override
        public Issuance findIssuanceBySidAndBid(Long sid, Long bid) {
                return this.issuanceRepo.findBySidAndBid(sid, bid).get();
        }

        @Override
        public void deleteIssuanceByBid(Long bid) {
                this.issuanceRepo.deleteByBid(bid);
        }

        @Override
        public void approveIssuance(Long sid, Long bid) {

                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
    	        Date date = new Date();
                
                this.issuanceRepo.approveIssuance(sid, bid, formatter.format(date));
        }

}
