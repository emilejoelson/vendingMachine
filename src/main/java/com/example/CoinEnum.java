package com.example;

public enum CoinEnum {
    ONE_DIRHAM(1),
    TWO_DIRHAMS(2),
    FIVE_DIRHAMS(5),
    TEN_DIRHAMS(10);

    private final int value;

    CoinEnum(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
