package com.chulm.study.chapter11;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class CompletableFuture03 {

    private static List<Shop> shops = Arrays.asList(new Shop("BuyItAll"), new Shop("BestPrice"));

    public static List<String> findPrices(String product){
        return shops.stream().map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product))).collect(Collectors.toList());
    }

    public static List<String> findParallelPrices(String product){
        return shops.parallelStream().map(shop -> String.format("%s price is %.2f", shop.getName(), shop.getPrice(product))).collect(Collectors.toList());
    }
    public static List<String> findPricesWithCompletableFuture(String product){
        List<CompletableFuture<String>> completableFutures =
                shops.stream().map(shop -> CompletableFuture.supplyAsync(() -> shop.getName() + "price is " + shop.getPrice(product)))
                             .collect(Collectors.toList());

        //2개의 파이프라인으로 나누어 처리했다.
        return completableFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }

    public static void main(String[] args){

        long startTime = System.currentTimeMillis();
//        findPrices("MyPhone27s");
//        findParallelPrices("MyPhone27s"); //병렬로
        findPricesWithCompletableFuture("MyPhone27s");
        long end = (System.currentTimeMillis() - startTime) ;

        System.err.println(end);

    }
}
