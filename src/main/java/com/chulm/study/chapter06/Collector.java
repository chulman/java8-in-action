package com.chulm.study.chapter06;

import com.chulm.study.asset.Food;

import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class Collector {
    public static void main(String[] args) {
        Collectors.toList();

        // Collector에서 제공하는 메소드의 기능은 크게 3가지로 구분
        // 1. 스트림 요소를 하나의 값으로 리듀스하고 요약
        // 2. 요소 그룹화
        // 3. 요소 분할


        List<Food> foodList = Arrays.asList(
                new Food(100, "Rice"),
                new Food(300, "Chocolate")
        );

        long howManyDish = foodList.stream().collect(Collectors.counting());
        System.err.println(howManyDish);

        //최대값 최소값 계산
        Food maxValueFood = foodList.stream().collect(Collectors.maxBy(Comparator.comparing(Food::getCalories))).get();
        Food minValueFood = foodList.stream().collect(Collectors.minBy(Comparator.comparing(Food::getCalories))).get();

        System.err.println(maxValueFood.toString());
        System.err.println(minValueFood.toString());

        //요약 연산
        int sum = foodList.stream().collect(Collectors.summingInt(Food::getCalories));
        System.err.println("sum:" + sum);


        //2개 이상의 연산을 수행할 때 ex) sum, max,
        IntSummaryStatistics data = foodList.stream().collect(Collectors.summarizingInt(Food::getCalories));
        System.err.println("data:" + data);

        //문자열 연결
        String allMenu = foodList.stream().map(Food::getName).collect(Collectors.joining(", "));
        System.err.println(allMenu);


        //범용 리듀스 요약 연산
        //3번쨰 파라미터는 BinaryOperator
//        int totalCount = foodList.stream().collect(Collectors.reducing(0, Food::getCalories, (a, b) -> a + b ));
        int totalCount = foodList.stream().collect(Collectors.reducing(0, Food::getCalories, Integer::sum));
        System.out.println(totalCount);
    }
}




