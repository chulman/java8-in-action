package com.chulm.study.chapter04;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class StreamTest01 {

    static List<Dish> menu = Arrays.asList(
            new Dish("pork", false, 500),
            new Dish("beef", false, 800),
            new Dish("rice", true, 350),
            new Dish("salmon", true, 350)
    );

    public static void main(String[] args) {
        List<String> chooseDish = menu.stream()
                .filter(dish -> dish.getCalories() > 300)
                .map(Dish::getName)
                .distinct()
                .limit(1)
                .collect(toList());

        menu.stream().filter(dish -> {
            System.out.println("filter" + dish.getName());
            return dish.getCalories()>300;
        })
                .map(dish -> {
                    System.out.println("mapping" +dish.getName());
                    return dish.getName();
                }).limit(2).collect(toList());

//
    }
}
