package com.chulm.study.chapter08;

public class RefactoringLambda01 {
    public static  void main(String[] args){

        // 익명 클래스의 변수 스코프
        int a = 10;
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                int a = 2;
                System.out.println(a);
            }
        };


        // compile error!
//        Runnable r2 = () -> {
//          int a = 3;
//            System.out.println(a);
//        };
    }
}
