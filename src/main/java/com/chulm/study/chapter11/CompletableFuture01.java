package com.chulm.study.chapter11;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class CompletableFuture01 {


    public static void main(String[] args){
        Shop shop = new Shop();
        long start = System.nanoTime();
        Future<Double> future = shop.getPriceAsync("product");
        long invocationTime = ((System.nanoTime()- start) / 1_000_000);

        System.err.println("invocationTime:" + invocationTime);

//        doSomething();

        try {
            //가격 정보를 받을때까지 블록한다.
            double price = future.get();


            System.out.println("price is " + price);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        long retrivalTIme = ((System.nanoTime()- start) / 1_000_000);
        System.err.println("retrivalTime:" + retrivalTIme);
    }
}
