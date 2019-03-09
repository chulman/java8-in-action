package com.chulm.study.asset;


import com.chulm.study.chapter05.Question.Trader;

public class Transaction {
    private final com.chulm.study.chapter05.Question.Trader trader;
    private final int year;
    private final int value;

    public Transaction(com.chulm.study.chapter05.Question.Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }


    public int getYear() {
        return year;
    }

    public int getValue() {
        return value;
    }

    public Trader getTrader() {
        return trader;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "trader=" + trader +
                ", year=" + year +
                ", value=" + value +
                '}';
    }
}
