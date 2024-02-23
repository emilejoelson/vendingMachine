package com.example;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AppTest
{
    private VendingMachineInterface vendingMachine;
    private ByteArrayOutputStream outputStream;

    @Test
    public  void TestInsertCoin2And5(){
        vendingMachine.insertCoin(2);
        vendingMachine.insertCoin(5);
        vendingMachine.selectProduct("coca");
    }
    @BeforeEach
    public void beforeEach() {
        vendingMachine = new VendingMachine();
    }

    //Test for the function not void
    @Test
    public  void TestSelectProductNoNull(){
             TestInsertCoinValid();
             Assertions.assertEquals("You purchased coca for 7 dirhams.Change: 5 dirhams",vendingMachine.selectProduct("coca"));
    }

    @Test
    public  void TestSelectProductNull(){
         Assertions.assertEquals("Product not found. Please select from available products.",vendingMachine.selectProduct("Rice"));
    }

    @Test
    public  void TestInsufficentSolde(){
         vendingMachine.insertCoin(2);
         Assertions.assertEquals("Insufficient balance. Please insert more coins or select a cheaper product.",vendingMachine.selectProduct("coca"));
    }

    //Test for the funcction void
     @AfterEach
     public  void afterEachVoidFunction(){
         System.setOut(System.out);
     }
     @Test
    public void TestRefund(){
        TestSelectProductNoNull();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        vendingMachine.refund();
        String expectedValue = "Refunding 5 dirhams.";
         String actualValue = outputStream.toString();
        Assertions.assertEquals(expectedValue,actualValue);
    }

    @Test
    public void TestCancelRequestWithIntBalance(){
        TestSelectProductNoNull();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        vendingMachine.cancelRequest();
        String expectedValue = "Request canceled. Your Solde is 5 dirhams.Refunding 5 dirhams.";
        String actualValue = outputStream.toString();
        Assertions.assertEquals(expectedValue,actualValue);
    }

    @Test
    public  void TestCancelRequestWithoutBalance(){
        TestInsertCoin2And5();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        vendingMachine.cancelRequest();
        String expectedValue = "No request to cancel.";
        String actualValue = outputStream.toString();
        Assertions.assertEquals(expectedValue,actualValue);
    }

    @BeforeEach
    public void beforeEachInsertAndReset() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public  void TestInsertCoinValid(){
        //Create vending machine instance
        vendingMachine.insertCoin(2);
        vendingMachine.insertCoin(10);
        //Getting the capture Output
        String expecetedOutPut = "Your 2 coin is valid. Current balance: 2 dirhams.Your 10 coin is valid. Current balance: 12 dirhams.";
        String actualOutPut = outputStream.toString();
        Assertions.assertEquals(expecetedOutPut,actualOutPut);
    }

    @Test
    public  void TestInsertCoinInvalid(){
        //Create vending machine instance
        vendingMachine.insertCoin(7);
        //Getting the capture Output
        String expecetedOutPut = "Invalid coin. You must enter 1, 2, 5, or 10 dirham coins only.";
        String actualOutPut = outputStream.toString();
        Assertions.assertEquals(expecetedOutPut,actualOutPut);
    }

    @Test
    public  void TestReset(){
        vendingMachine.reset();
        String expectedValue = "Vending machine reset successful.";
        String actualValue = outputStream.toString();
        Assertions.assertEquals(expectedValue,actualValue);
    }
}
