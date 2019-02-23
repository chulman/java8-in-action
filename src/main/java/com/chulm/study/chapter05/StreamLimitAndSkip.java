package com.chulm.study.chapter05;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamLimitAndSkip {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 2, 1, 12, 1, 3, 5);

//        numbers.stream().filter(integer -> integer < 3)
//                .limit(3)
//                .forEach(System.err::println);
//
//        Stream<Integer> stream = numbers.stream().filter(integer -> integer < 3).limit(3);
//        stream.forEach(System.err::println);

        numbers.stream().filter(integer -> integer < 3)
                .skip(2)        //filter된 처음 N개 건너뛰기
                .forEach(System.err::println);
    }
}
