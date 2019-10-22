package com.chulm.study.chapter10;

import java.util.Optional;


public class Optional02 {
    public static void main(String[] args){

        Insurance insurance = null;

        Optional<Insurance> optionalInsurance = Optional.ofNullable(insurance);
        //optional의 값을 포함하면, Map의 인수로 제공된 함수의 값을 바꾼다. 값이 없으면 아무 일도 일어나지 않음.
        Optional<String> name = optionalInsurance.map(Insurance::getName);
        //empty
        System.err.println(name);
    }
}
