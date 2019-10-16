package com.chulm.study.chapter09;

interface A{
    default void hello(){
        System.err.println("hello from A");
    }
}

interface B extends A{
    default void hello(){
        System.err.println("hello from B");
    }
}

class D implements A {
    /*
     * 오버라이딩하여 구현하면 1 우선권을 갖는다.
     */
//    @Override
//    public void hello() {
//        System.err.println("hello from D");
//    }
}
public class DefaultMethodImpl02 extends D implements A, B{



    public static void main(String[] args){
        // sub 인터페이스가 이긴다.
        new DefaultMethodImpl02().hello();

    }
}
