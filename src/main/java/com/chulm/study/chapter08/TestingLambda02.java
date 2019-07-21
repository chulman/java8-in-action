package com.chulm.study.chapter08;


import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
 * 고차원 함수 테스팅
 */
public class TestingLambda02 {

    public void test() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        List<Integer> even = filter(list, integer -> integer % 2 == 0);

        System.out.println(even.contains(2));//true
        System.out.println(even.contains(1));//false

    }

    public List<Integer> filter(List<Integer> list, Predicate<Integer> predicate) {
        return list.stream().filter(predicate).collect(Collectors.toList());
    }
}
