package com.chulm.study.chapter09;

interface E {
    default  void hello(){
        System.err.println("hello from e");
    }
}
interface F {
    default  void hello(){
        System.err.println("hello from f");
    }
}
public class DefaultMethodImpl03 implements E, F{
    //컴파일 오류가 나기 때문에 명시적으로 구현해야 한다.
    @Override
    public void hello() {

    }

    public static void main(String[] args){

    }
}
