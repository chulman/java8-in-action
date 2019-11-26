package com.chulm.study.chapter11;


import javax.xml.namespace.QName;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

// discount 서비스를 이용한 가장 간단한 구현
public class CompletableFuture04 {

    private static List<Shop> shops = Arrays.asList(new Shop("BuyItAll"), new Shop("BestPrice"));
    //성능과는 거리가 멀다.
    public static List<String> findPrices(String product){
        return shops.stream()
        .map(shop -> shop.getPrice(product))
        .map(Quote::parse)
        .map(Discount::applyDiscount)
        .collect(Collectors.toList());
    }
    public static List<String> findPricesAsync(String product){
        Executor executor = Executors.newFixedThreadPool(1);
        List<CompletableFuture<String>> priceFutures = shops.stream()
                                                            .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product), executor))
                                                            .map(future -> future.thenApply(Quote::parse))  //then apply는 future가 끝날때까지 블록하지 않는다.
                                                            // 동기적 작업의 수행
                                                            .map(future -> future.thenCompose(quote -> CompletableFuture.supplyAsync(() -> Discount.applyDiscount(quote))))
                                                            .collect(Collectors.toList());

        return priceFutures.stream()
                .map(CompletableFuture::join) //스트림의 모든 future가 종료되길 기다렸다가 결과를 추출
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
//        findPrices("MyPhone27s");

        /**
         * supply async ->thenApply -> thenCompose(결과 future를 다른 비동기 작업과 조합한다)
         */
        findPricesAsync("MyPhone27s");
        long end = (System.currentTimeMillis() - startTime) ;

        System.err.println(end);

    }
}
