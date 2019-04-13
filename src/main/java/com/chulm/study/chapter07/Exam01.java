package com.chulm.study.chapter07;

import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class Exam01 {
    private static AtomicLong sum = new AtomicLong(0);
    public static void main(String[] args){
        // 쓰레드로 숫자 1부터 n까지 모든 숫자의 합계를 반환하는 메소드를 구현


        Thread[] threadArr = new Thread[10];

        for(int i=0; i<threadArr.length; i++){
            threadArr[i] = new Thread(() -> {
                sum.addAndGet( sum.get() + getSeqSum(10));
//                sum.addAndGet( sum.get() + parrallelGetSeqSum(10));
                System.err.println(sum);
            });
            threadArr[i].start();
        }
        while(true){
            try {
                Thread.sleep(1000);
                System.out.println(sum);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static long getSeqSum(long n){
        return Stream.iterate(1l, aLong -> aLong +1)
                     .limit(n)
                     .reduce(0l,Long::sum);
    }


    public static long iterativeSum(long n){
        long result = 0;
        for(long i= 1l; i<=n; i++){
            result += i;
        }
        return result;
    }

    public static long parrallelGetSeqSum(long n){
        return Stream.iterate(1l, aLong -> aLong +1)
                .limit(n)
                .parallel() //병렬 스트림으로 전환
                .reduce(0l,Long::sum);
    }
}
