package com.chulm.study.chapter08;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DebuggingLambda {
    public static void main(String[] args){

        List<Integer> numbers = Arrays.asList(2,3,4,5);

        // peek, map, filter, limit을 통한 정보 로깅
        // peek은 스트림의 요소를 소비하지 않고 다음 파이프라인으로 전달한다.

        List<Integer> result = numbers.stream().peek(integer -> System.out.println("from stream :" + integer))
                                               .map(integer -> integer + 17)
                                               .peek(integer -> System.out.println("after map :" + integer))
                                               .filter(integer -> integer%2==0)
                                               .peek(integer -> System.out.println("after filter :" + integer))
                                               .collect(Collectors.toList());


        // NPE 발생
        // 람다와 관련한 스택 트레이스는 이해하기 어려울 수 있다!!
        List<String> list = Arrays.asList("a","b",null);
        list.stream().map(s -> s.equals("a")).forEach(System.out::println);


    }
}
