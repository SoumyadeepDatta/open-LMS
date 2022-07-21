package com.thinkxfactor.springdemo.services;

public interface BookQtyMgr {

    void bookQtyInc(Long bid, Integer val);

    void bookQtyInc(Long bid);

    void bookQtyDec(Long bid, Integer val);

    void bookQtyDec(Long bid);

    Integer getBookQty(Long bid);

    void handleNegQty();
}
