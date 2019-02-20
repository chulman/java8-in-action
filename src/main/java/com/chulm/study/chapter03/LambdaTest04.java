package com.chulm.study.chapter03;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static java.util.Comparator.comparing;

public class LambdaTest04 {

    public static void main(String[] args) {

        List<Apple> inventory = new ArrayList<>();

        inventory.add(new Apple(1,"red"));
        inventory.add(new Apple(2,"blue"));


        inventory.sort((o1, o2) -> o1.getWeight().compareTo(o2.getWeight()));
        inventory.sort((comparing(apple -> apple.getWeight())));
        inventory.sort(comparing(Apple::getColor));
    }

}
