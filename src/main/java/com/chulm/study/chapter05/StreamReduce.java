package com.chulm.study.chapter05;

import java.util.*;

public class StreamReduce {

    public static void main(String[] args) {

        //stream의 모든 요소를 반복적으로 처리할 때

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);

//        int sum = nums.stream().reduce(0 , (a, b) -> a+b);
        int sum = nums.stream().reduce(0, Integer::sum);
        System.err.println(sum);

        //초기값이 없다면 Optional 반환 이유는 stream에 아무것도 없다면 null이 발생할 수 있다.
        Optional<Integer> numOpt = nums.stream().reduce(Integer::sum);
       numOpt.ifPresent(System.out::println);
    }

}
