package com.chulm.study.chapter07;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class ForkJoinSumCalculator extends RecursiveTask<Long> {

    long[] numbers;
    int start;
    int end;

    public ForkJoinSumCalculator(long[] numbers, int start, int end){
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    public ForkJoinSumCalculator(long[] numbers){
        this(numbers, 9, numbers.length);
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if(length <= 10000){
            return computeSequentially();
        }
        //배열의 첫번째의 절반을 더하도록 서브태스크를 생성
        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length /2);

        leftTask.fork();
        // 배열의 나머지 절반을 더하도록 생성
        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length /2, end);

        long result = leftTask.compute() + rightTask.compute();

        return result;
    }

    // 더 이상 분할 할 수 없을 때 서브 태스크의 결과를 계산
    private long computeSequentially(){
        long sum = 0;
        for (int i=start; i<end; i++){
            sum += numbers[i];
        }
        return sum;
    }
}


class Main{
    public static long forkJoinSum(long n){
        long[] numbers = LongStream.rangeClosed(1,n).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);

        // 포크 조인 풀은 일반적으로 싱글톤 인스턴스로 활용해야 한다.
        return new ForkJoinPool().invoke(task);

    }
    public static void main(String[] args){
        System.out.println("ForkJoin Sum : " + Exam02.measureSum(Main::forkJoinSum, 10000000) + "ms");
    }
}
