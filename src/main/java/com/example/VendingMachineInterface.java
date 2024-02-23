package com.example;

public interface VendingMachineInterface {
    void insertCoin(int coin);
     String selectProduct(String prod);
    void cancelRequest();
    void reset();
    void refund();
}

