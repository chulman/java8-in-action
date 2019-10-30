package com.chulm.study.chapter11;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CompletableFuture02 {


    public static void main(String[] args) {
        Shop shop = new Shop();

        Future<Double> future = shop.getPriceSupplyAsync("product");
        try {
            System.err.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
