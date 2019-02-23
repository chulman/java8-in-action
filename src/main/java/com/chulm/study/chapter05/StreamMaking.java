package com.chulm.study.chapter05;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class StreamMaking {
    public static void main(String[] args){

        //값으로 스트림 만들기
        Stream<String> stream = Stream.of("Test", "Test1");
        stream.forEach(System.out::println);

        //배열로 스트림만들기
        int[] numbers = {2,3,5,11};
        Arrays.stream(numbers).sum();

        //파일로 스트림만들기
        long uniqueWords = 0;

        try(Stream<String> lines = Files.lines(Paths.get("data.txt"),Charset.defaultCharset())){
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" "))).distinct().count();
        }catch (IOException e){
            e.printStackTrace();
        }

        //함수로 무한 스트림 만들기
        //1. iterate 2.generate
        Stream.iterate(0,integer -> integer+2).limit(10).forEach(System.out::println);
        Stream.generate(Math::random).limit(10).forEach(System.out::println);

        //... 무한 스트림을 만들 경우 limit을 하지 않으면 계산이 반복되므로, 정렬하거나 reduce할 수 없다.



    }
}
