package com.chulm.study.chapter08;

import java.util.ArrayList;
import java.util.List;

/**
 * 객체 지향 디자인 패턴을 활용한 리팩토링 - observer
 */
public class RefactoringLambda06 {

    interface Observer {
        void notify(String tweet);
    }


    static class Guardian implements Observer {
        @Override
        public void notify(String tweet) {
            System.out.println("Guardian:" + tweet);
        }
    }

    interface Subject {
        void registerObserver(Observer o);
        void notifyObservers(String tweet);
    }

    static class Feed implements Subject {
        List<Observer> observerList = new ArrayList<>();

        @Override
        public void registerObserver(Observer o) {
            observerList.add(o);
        }

        @Override
        public void notifyObservers(String tweet) {
            observerList.stream().forEach(observer -> observer.notify(tweet));
        }
    }

    public static void main(String[] args){
        Guardian guardian = new Guardian();

        Feed feed = new Feed();
        feed.registerObserver(guardian);
        feed.registerObserver(tweet -> System.err.println("FoodBall:" + tweet));
        feed.registerObserver(tweet -> System.err.println("Sciences:" + tweet));
        feed.notifyObservers("빅 뉴스!");
    }
}
