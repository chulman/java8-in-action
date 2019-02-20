package com.chulm.study.chapter01;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Annonymous-function : 익명함수
 */



public class Lambda {

    public void base() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                /**
                 * code
                 */
                System.out.println("hi");
            }
        });
    }

    public void change() {
        Thread thread = new Thread(() -> {
            System.out.println("a");
        });


    }







}
