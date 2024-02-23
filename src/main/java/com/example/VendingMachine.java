package com.example;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class VendingMachine implements VendingMachineInterface {
    private int balance;
    private final Map<Integer, CoinEnum> validCoins;
    private final Map<String, Integer> productPrices;

    public VendingMachine() {
        balance = 0;
        validCoins = initializeValidCoins();
        productPrices = initializeProductPrices();
    }

    private Map<Integer, CoinEnum> initializeValidCoins() {
        Map<Integer, CoinEnum> coins = new HashMap<>();
        for (CoinEnum coinEnum : CoinEnum.values()) {
            coins.put(coinEnum.getValue(), coinEnum);
        }
        return coins;
    }


    private Map<String, Integer> initializeProductPrices() {
        Map<String, Integer> prices = new HashMap<>();
        for (ProductEnum product : ProductEnum.values()) {
            prices.put(product.getName(), product.getPrice());
        }
        return prices;
    }

    @Override
    public void insertCoin(int coin) {
        CoinEnum validCoin = validCoins.get(coin);
        if (validCoin != null) {
            balance += coin;
            System.out.print("Your " + validCoin.getValue() + " coin is valid. Current balance: " + balance + " dirhams.");
        } else {
            System.out.print("Invalid coin. You must enter 1, 2, 5, or 10 dirham coins only.");
        }
    }

    @Override
    public String selectProduct(String productName) {
        Integer price = productPrices.get(productName);
        if (price != null) {
            if (balance >= price) {
                int change = balance - price;
                balance -= price;
                String result = "You purchased " + productName + " for " + price + " dirhams.";
                if (change > 0) {
                    result += "Change: " + change + " dirhams";
                }
                return result;
            } else {
                return "Insufficient balance. Please insert more coins or select a cheaper product.";
            }
        } else {
            return "Product not found. Please select from available products.";
        }
    }

    @Override
    public void cancelRequest() {
        if (balance > 0) {
            System.out.print("Request canceled. Your Solde is " + balance + " dirhams.");
            refund();
        } else {
            System.out.print("No request to cancel.");
        }
    }

    @Override
    public void reset() {
        balance = 0;
        System.out.print("Vending machine reset successful.");
    }

    public void refund() {
        System.out.print("Refunding " + balance + " dirhams.");
        balance = 0;
    }
}
