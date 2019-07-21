package com.chulm.study.chapter08;


import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * 객체 지향 디자인 패턴을 활용한 리팩토링 - 의무 체인
 * : 순차적 처리 A -> B -> C
 */

public class RefactoringLambda07 {

    static class HeaderProcess extends ProcessingObject {
        @Override
        protected Object handleWork(Object input) {
            return "http header handle work " + input;
        }
    }

    static class HttpProcess extends ProcessingObject {
        @Override
        protected Object handleWork(Object input) {
            return "success~";
        }
    }

    public static void main(String[] args){
        HeaderProcess headerProcess = new HeaderProcess();
        HttpProcess httpProcess = new HttpProcess();
        httpProcess.setPreoProcessor(headerProcess);
        System.out.println(httpProcess.handle("<head>s</head>"));


        //lambda를 통한 표현

        UnaryOperator<String> testProcess = s -> s + " is test1 process";
        UnaryOperator<String> test2Process = s -> s + " is test2 process";

        Function<String, String> pipeline = testProcess.andThen(test2Process);

        String result = pipeline.apply("aa");
        System.err.println(result);

    }


}

abstract class ProcessingObject<T>{
    private ProcessingObject<T> next;

    public void setPreoProcessor(ProcessingObject<T> next) {
        this.next = next;
    }

    public T handle(T input){
        T t = handleWork(input);
        if(next != null){
            return next.handle(t);
        }
        return t;

    }

    protected abstract T handleWork(T input);
}


