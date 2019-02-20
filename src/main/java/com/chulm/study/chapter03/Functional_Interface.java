package com.chulm.study.chapter03;


@FunctionalInterface
interface add{

    int add(int a, int b);
}

interface smartadd extends  add{
    int add(double a, double b);
}

public class Functional_Interface implements add{
    public static void main(){


    }

    @Override
    public int add(int a, int b) {
        return 0;
    }
}
