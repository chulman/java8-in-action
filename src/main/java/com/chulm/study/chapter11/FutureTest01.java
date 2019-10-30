package com.chulm.study.chapter11;

import java.util.concurrent.*;

public class FutureTest01 {


    public static void doPrint(){
        System.err.println("hello");
    };
    public static void main(String[] args){
        ExecutorService executorService = Executors.newCachedThreadPool();

        Future<Double> future = executorService.submit(new Callable<Double>() {
            @Override
            public Double call() throws Exception {
                Thread.sleep(500);
                return 2d;
            }
        });



        doPrint();
        try {
            //비동기 결과를 1초까지 기다린다.
          Double result =  future.get(1, TimeUnit.SECONDS);
            System.err.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }


    }
}
