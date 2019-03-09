package com.chulm.study.chapter06;

import com.chulm.study.asset.Food;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Grouping {
    public static void main(String[] args) {

        List<Food> foodList = Arrays.asList(
                new Food(100, "Rice"),
                new Food(200, "Rice"),
                new Food(400, "Rice"),
                new Food(300, "Chocolate")
        );

        Map<String,List<Food>> foodByName = foodList.stream().collect(Collectors.groupingBy(Food::getName));
        foodByName.forEach((s, foods) -> {
            System.out.println(
                    "food" + s
            );

            foods.forEach(System.out::println);
        });

        //서브 그룹으로 데이터 수집

        Map<String, Long> nameCount = foodList.stream().collect(Collectors.groupingBy(Food::getName, Collectors.counting()));
        nameCount.forEach((s, aLong) -> System.err.println("name:" + s + " count=" + aLong));

        //서브 그룹에서 가장 칼로리가 높은 요리 찾기
        Map<String, Food> mostCaloricByName = foodList.stream().collect(Collectors.groupingBy(Food::getName,
                                                                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Food::getCalories)),Optional::get)));
        mostCaloricByName.forEach((s, food) -> System.err.println(s + ", " + food.toString()));

        //분할 (Partitioning)
        Map<Boolean, List<Food>> nameMap = foodList.stream().collect(Collectors.partitioningBy(Food::foodIsRice));
        nameMap.forEach((s, food) -> System.err.println("isRice?:" + s + ", " + food.toString()));

        //숫자를 소수와 비소수로 분할
        //정수를 인수로 받아 2에서 n까지의 자연수를 소수와 비소수로 나누는 프로그램
        System.out.println(isPrime(5));
        System.out.println(isPrime(10));

        isPrimeBoxing(5);
    }

    public static boolean isPrime(int cadidate){
        return IntStream.range(2, cadidate).noneMatch(value -> cadidate % value == 0);
    }

    public static Map<Boolean, List<Integer>> isPrimeBoxing(int value){
        return IntStream.rangeClosed(2, value).boxed().collect(Collectors.partitioningBy(candidate -> isPrime(value)));
    }
}




