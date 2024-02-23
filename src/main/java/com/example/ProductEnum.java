package com.example;

public enum ProductEnum {
    WATER("water", 5),
    COCA("coca", 7),
    TWIX("twix", 10),
    BUENO("bueno", 12);

    private final String name;
    private final int price;

    ProductEnum(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
