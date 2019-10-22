package com.chulm.study.chapter10;

import java.util.Optional;


public class Optional01 {


    public static void main(String[] args){
        //빈 optional
        Optional<Car> optionalCar = Optional.empty();

        //null이 아닌 값으로 Optional 만들기
        //car가 null이면 NPE 발생한다.
        Car car = null;
        Optional<Car> optionalCar2 = Optional.of(car);
        System.err.println(optionalCar2);
        // null이면 빈 Optional 반환한다.
        Optional<Car> optionalCar3 = Optional.ofNullable(car);
        System.err.println(optionalCar3);
    }


}
