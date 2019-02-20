package com.chulm.study.chapter02;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class CompareWIthApple {

    public static void main(String[] args) {

        List<Apple> apples = new ArrayList<>();
        apples.add(new Apple(15, "ged"));
        apples.add(new Apple(20, "green"));

        for (int i = 0; i < apples.size(); i++) {
            System.out.println(apples.get(i));
        }
        sort(apples);

        for (int i = 0; i < apples.size(); i++) {
            System.out.println(apples.get(i));
        }

        apples.stream().sorted((o1, o2) -> {
            return o1.getWeight().compareTo(o2.getWeight());
        });
    }


    public static void sort(List<Apple> apples) {

        /*apples.sort(new Comparator<Apple>() {

            public int compare(Apple o1, Apple o2) {
                return o1.getColor().compareTo(o2.getColor());
            }
        });*/

        lambdaSort(apples);

    }

    public static void lambdaSort(List<Apple> apples) {

        apples.sort((o1, o2) -> {
            return o1.getWeight().compareTo(o2.getWeight());
        });

    }
}

