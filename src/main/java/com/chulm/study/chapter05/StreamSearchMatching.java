package com.chulm.study.chapter05;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamSearchMatching {

    public static void main(String[] args) {


        List<String> strList = Arrays.asList("", "world", "test1", "test2", "test3");


        //anyMatch, allMatch, noneMatch -> &&, || shortCircuit 기법
        //shortCircuit : 원하는 연산을 수행했다면 , 연산 모두 수행하지 않고 즉각적인 반환

        //predicates 적어도 한 요소와 일치
        System.err.println(strList.stream().anyMatch(s -> s.isEmpty()));

        //predicates가 모두 일치
        System.err.println(strList.stream().allMatch(s -> s.isEmpty()));
        // allmatch와 반대
        System.err.println(strList.stream().noneMatch(s -> s.isEmpty()));


        //optional 값의 존재나 부재여부를 표현하는 컨테이너 클래스
        //findAny와 findFirst의 주 사용 -> 병렬성, 병렬실행에서는 첫번째 요소를 찾기 어려운데 병렬요소에서 제약이 적은 any를 많이 사용

        Optional<String> strOpt = strList.stream().filter(s -> s.startsWith("g"))
                                                  .findAny();

        //값이 있으면 표현, 없으면 표현하지 않음
        strOpt.ifPresent(s -> System.out.println(s));

        strList.stream().map(s -> s.toUpperCase())
                        .findFirst().ifPresent(System.out::println);
    }

}
