package com.chulm.study.chapter03;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;


public class LambdaTest05 {

    public static void main(String[] args) {

        List<Apple> inventory = new ArrayList<>();

        inventory.add(new Apple(1,"red"));
        inventory.add(new Apple(2,"blue"));


        //predicate
        Predicate<String> nonEmptyString = s -> !s.isEmpty();
        Predicate<String> emptyString = s -> s.isEmpty();
        System.err.println(nonEmptyString.test("")); //false
        System.err.println(nonEmptyString.and(emptyString).test("")); //두개의 조건을 모두 만족해야하므로 false
        System.err.println(nonEmptyString.or(emptyString).test("")); //둘중 하나만 만족해도 되므로 true
        System.err.println(nonEmptyString.negate().test("")); // nonEmpytyString predicate의 반대상황을 테스트 true


        //consumer
        Consumer<String> outConsumer = s -> System.out.println(s);
        Consumer<String> errConsumer = s -> System.err.println(s);

        outConsumer.accept("k");  //k
        outConsumer.andThen(errConsumer).accept("g"); // g, g

        //function
        Function<String,String> lowerFunction = s -> s.toLowerCase();
        Function<String,String> upperFunction = s -> s.toUpperCase();

        System.out.println(lowerFunction.apply("S"));       //s
        System.out.println(lowerFunction.andThen(upperFunction).apply("S"));    // S

    }

}
