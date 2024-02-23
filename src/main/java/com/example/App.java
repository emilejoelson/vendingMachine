package com.example;

public class App {
    public static void main(String[] args) {
      VendingMachineInterface vendingMachine = new VendingMachine() ;

       //insertions of coins
        vendingMachine.insertCoin(2);
        vendingMachine.insertCoin(10);
        System.out.println("\n\n");
        String select01 = vendingMachine.selectProduct("coca");
        System.out.println(select01);


        vendingMachine.refund();
        vendingMachine.cancelRequest();

        //vendingMachine.reset();
    }
}
