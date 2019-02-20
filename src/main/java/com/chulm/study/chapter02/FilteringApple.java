package com.chulm.study.chapter02;

import com.chulm.study.*;

import java.util.ArrayList;
import java.util.List;

public class FilteringApple {


    public static void main(String[] args) {

        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(5, "red"));
        apples.add(new Apple(150, "green"));


        // 반복 되는 코드
        Apple apple = getAppleWithColorPredicate(new ApplePredicate() {
            @Override
            public boolean test(Apple apple) {
                return apple.getColor().equals("green");
            }
        }, apples);

        // 람다 활용
        Apple apple2 = getAppleWithColorPredicate((Apple a) -> {
            return a.getColor().equals("green");
        }, apples);


    }


    public static Apple getAppleWithColorPredicate(ApplePredicate predicate, List<Apple> appleList) {

        for (Apple apple : appleList) {
            if (predicate.test(apple)) {
                return apple;
            }
        }
        return null;
    }

}


class FilteringAppleWithColor implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return apple.getColor().equalsIgnoreCase("green");
    }
}












