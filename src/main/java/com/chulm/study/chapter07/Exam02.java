package com.chulm.study.chapter07;

import java.util.function.Function;
import java.util.stream.LongStream;

//성능 측정
public class Exam02 {
    public static void main(String[] args){
        //n개의 숫자를 더하는 함수의 성능 측정

        //10 번 반복하여 시간을 밀리초 단위로 측정하고 가장 짧은 시간을 반환

        System.out.println("seq sum done :" + measureSum(Exam01::getSeqSum, 10_000_000) + "ms");
        System.out.println("seq sum done :" + measureSum(Exam01::iterativeSum, 10_000_000) + "ms");
        System.out.println(" sum done :" + measureSum(Exam01::parrallelGetSeqSum, 10_000_000) + "ms");

        // 결과 2>1>3
        // for 루프를 사용한 반복 버전이 생각보다 빠르다. 기본값을 박싱하거나 언박싱할 필요가 없어서..
        // Iterator가 박싱된 객체를 생성하고, 이를 다시 언박싱한다.
        // 또한 병렬로 실행할 경우 독립적인 청크로 분할하기가 어려웠고, 이에따라 성능저하가 일어났다.

        /**
         * 특화된 메소드의 사용 -> LongStream.rangeClosed , 기본형 Long을 사용하므로 박싱과 언박싱 오버헤드가 사라짐.
         * 쉽게 청크로 분할 할 수 있는 숫자 범위를 생산
         */
        System.out.println("seq sum done :" + measureSum(Exam02::rangedSum, 10_000_000) + "ms");
        System.out.println("sum done :" + measureSum(Exam02::parallelRangedSum, 10_000_000) + "ms");
        // 결과 5>2>4>1>3
    }

    public static long rangedSum(long n){
        return LongStream.rangeClosed(1,n)
                         .reduce(0,Long::sum);
    }
    public static long parallelRangedSum(long n){
        return LongStream.rangeClosed(1,n)
                .parallel()
                .reduce(0,Long::sum);
    }

    public static long measureSum(Function<Long,Long> adder, long n){
        long fastest = Long.MAX_VALUE;

        for(int i=0; i<10; i++){
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start) / 1_000_000;

            System.out.println("result:" + sum +", duration:" + duration);

            if(duration <fastest) fastest = duration;
        }
        return fastest;
    }
}
