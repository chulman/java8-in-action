package com.chulm.study.chapter04;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamTest02 {

    static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 500),
            new Dish("beef", false, 800),
            new Dish("rice", true, 350),
            new Dish("salmon", true, 350)
    );

    public static void main(String[] args){


        Stream<Dish> a = menu.stream();
        a.forEach(dish -> System.out.println(dish.getName()));

        List<String> title = Arrays.asList("a", "b", "c");
        Stream<String> s = title.stream();
        s.forEach(System.out::println);
        s.forEach(System.out::println);//stream은 한번만 탐색한다.
    }
}
