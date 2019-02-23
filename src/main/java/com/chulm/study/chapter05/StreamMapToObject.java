package com.chulm.study.chapter05;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMapToObject {

    //java8에서는 3가지 기본형 특화 스트림 - IntStream, DoubleStream, LongStream
    public static void main(String[] args){
        List<Food> foodList = Arrays.asList(
                new Food(100,"Rice"),
                new Food(300,"Chocolate")
        );

        //기본 형 특화스트림을 통해 sum 이나 min, max 등 연산에 필요한 항목을 제공받는다.
        foodList.stream().mapToInt(Food::getCalories)
                         .sum();


        IntStream intStream = foodList.stream().mapToInt(Food::getCalories);
        //객체 스트림으로 복원
        Stream<Integer> stream = intStream.boxed();

        //짝수의 개수

       IntStream intStream1 =  IntStream.rangeClosed(1, 100).filter(value -> value % 2 == 0);
        System.err.println(intStream1.count());
    }
}





class Food {
    int calories;
    String name;

    public Food(int calories, String name) {
        this.calories = calories;
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Food{" +
                "calories=" + calories +
                ", name='" + name + '\'' +
                '}';
    }
}
