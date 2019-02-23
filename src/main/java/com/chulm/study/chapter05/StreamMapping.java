package com.chulm.study.chapter05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMapping {

    public static void main(String[] args) {
        //map or flatMap

        List<String> strList = Arrays.asList("hello", "world", "test1", "test2", "test3");

        //예를 들어 데이터베이스 테이블의 특정 열만 지정 가능
        // 새로운 요소로 매핑

//        strList.stream().map(String::toUpperCase)
//                        .collect(Collectors.toList())
//                        .forEach(System.out::println);


        //String[] 형식을 가지고 있다.
//        strList.stream().map(word -> word.split("")).collect(Collectors.toList()).forEach(System.out::println);

//        String[] arryOfWords = {"goodbye", "worlds"};
//        Stream<String> streamOfWords = Arrays.stream(arryOfWords);

//        strList.stream().map(w -> w.split(""))
//                        .map(Arrays::stream)
//                        .distinct()
//                        .forEach(System.out::println);

//        strList.stream().map(w -> w.split(""))
//                        .flatMap(Arrays::stream)
//                        .forEach(System.out::print);

        /**
         * Q1)  [1,2,3,4,5] -> [1,4,9,16,25]
         */

        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5);

        numList.stream().map(integer -> integer * integer)
                .forEach(System.out::println);

        /**
         * Q2)  [1,2,3] [3,4] -> ([1,3], [1,4], [2,3], [2,4], [3,3], [3,4])
         */

        List<Integer> numList1 = Arrays.asList(1, 2, 3);
        List<Integer> numList2 = Arrays.asList(3, 4);

        numList1.stream().flatMap(i -> numList2.stream().map(j -> new int[]{i, j}))
                            .collect(Collectors.toList())
                            .forEach(ints -> System.out.println(Arrays.toString(ints)));

        /**
         * Q3)  return %3 == 0
         */
        numList1.stream().flatMap(i -> numList2.stream().filter(j -> (i + j) % 3 == 0).map(j -> new int[]{i, j}))
                            .collect(Collectors.toList())
                            .forEach(ints -> System.out.println(Arrays.toString(ints)));;

    }
}







