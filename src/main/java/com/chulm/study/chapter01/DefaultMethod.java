package com.chulm.study.chapter01;


interface Calcuator {

    default void add(int a, int b) {
        System.out.println((a+b));
    }

    default void minus(int a, int b) {
        System.out.println((a-b));
    }

}

interface  DoubleCalculator {
    default void add(int a, int b) {
        System.out.println((a+b)*2);
    }

    default void minus(int a, int b) {
        System.out.println((a-b)*2);
    }


}

interface CalOrDoubleCal extends Calcuator,DoubleCalculator{

    @Override
    default void add(int a, int b){
        Calcuator.super.add(a,b);
        DoubleCalculator.super.add(a,b);
    };
    @Override
    default void minus(int a, int b) {
        Calcuator.super.minus(a,b);
        DoubleCalculator.super.minus(a,b);
    }

}


public class DefaultMethod implements CalOrDoubleCal{

    public void cal(){
        add(3,5);
    }
}
