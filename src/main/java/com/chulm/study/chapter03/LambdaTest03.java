package com.chulm.study.chapter03;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaTest03 {

    public static void main(String[] args) {

        List<String> inventory = new ArrayList<>();

        inventory.add("b");
        inventory.add("a");

        inventory.sort(String::compareTo);  // 메소드 첨조

        Function<Integer, String> c2 = integer -> new String("Test");

        String s = c2.apply(110);
        c2.apply(2220);


        Map<String, Function<Integer,String>> map = new HashMap<>();

//        map.put("a", String::new);
        map.get("a").apply(110);

    }
}
