package com.chulm.study.chapter05;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StreamDistinct {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 1, 2, 1, 12, 1, 3, 5);

//        numbers.stream().filter(integer -> integer < 2)
//                .distinct()
//                .forEach(System.out::println);

        numbers.stream().filter(StreamDistinct::isLowerNumberTwo)
                .distinct()
                .forEach(System.out::println);
    }

    public static boolean isLowerNumberTwo(Integer number) {
        return new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer < 2;
            }
        }.test(number);
    }
}
