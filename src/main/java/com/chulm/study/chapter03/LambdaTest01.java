package com.chulm.study.chapter03;

import java.util.Comparator;

public class LambdaTest01 {

    public static void main(String[] args) {
        Comparator<Integer> byweight = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // -1 , 0 ,1
                return o1.compareTo(o2);
            }
        };


        Comparator<Integer> byweight2 = (o1, o2) -> {
            return o1.compareTo(o2);
        };


        System.err.println(byweight.compare(0, 1));
        System.err.println(byweight2.compare(2,3));
    }
}
