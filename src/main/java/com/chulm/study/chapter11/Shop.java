package com.chulm.study.chapter11;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

class Shop {

    Random random = new Random();

    //동기적 메소드
    public double getPrice(String product){
        return calculatePrice(product);
    }

    //비동기 메소드
    public Future<Double> getPriceAsync(String product){
        //계산결과를 포함할 CompletableFuture 생성
        CompletableFuture<Double> doubleCompletableFuture = new CompletableFuture<>();
        //새로운 쓰레드에 할당한다
        new Thread(() -> {
            try {
                double price = calculatePrice(product);
                //계산이 완료되면 complete에 값을 설정
                doubleCompletableFuture.complete(price);
            } catch (Exception e){
                //에러가 발생하면 future종료
                doubleCompletableFuture.completeExceptionally(e);
            }

        }).start();
        //기다리지 않고 리턴
        return doubleCompletableFuture;
    }

    //팩토리 메소드 supplyAsync로 간단 구현
    public Future<Double> getPriceSupplyAsync(String product){
        //forkJoinPool executors 중 하나가 supplier 실행
        return CompletableFuture.supplyAsync(() -> calculatePrice(product));
    }

    public static void delay(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private double calculatePrice(String product){
        delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }
}