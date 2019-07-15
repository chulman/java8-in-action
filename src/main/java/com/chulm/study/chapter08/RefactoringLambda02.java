package com.chulm.study.chapter08;

public class RefactoringLambda02 {

    static interface  Task {
        public void execute();
    }

    public static void doSomething(Runnable r){
        r.run();
    }

    public static void doSomething(Task a){
        a.execute();
    }

    public static void main(String[] args){

        doSomething(new Task() {
            @Override
            public void execute() {
                System.out.println("Danger danger");
            }
        });

        /*
         * compile error!!
         * Runnable과 task 중 모호하다.
         * 명시적 형변환이 가능하긴 하다..
         */
//        doSomething(() -> System.out.println("aa"));
        doSomething((Task)() -> System.out.println("danger"));

    }
}
