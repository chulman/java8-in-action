package com.chulm.study.chapter08;

import java.util.function.Consumer;

/**
 * 객체 지향 디자인 패턴을 활용한 리팩토링 - template method
 */
public class RefactoringLambda05 {
    static class OnlineBanking {
        public void processCustomer(int id){
//            String customer = Database.get(id);
              String customer = String.valueOf(id);
              makeCustomerHappy(customer);
        }
        private void makeCustomerHappy(String customer){
            System.out.println("customer=" + customer);
        }


        public void processCustomer(int id, Consumer<String> makeCustomHappy){
//            String customer = Database.get(id);
            String customer = String.valueOf(id);
            makeCustomHappy.accept(customer);
        }

        public static void main(String[] args){
//            OnlineBanking banking = new OnlineBanking();
//            banking.processCustomer(3);


            // 함수형 인터페이스를 통해 람다로 구현 가능하도록 함
            new OnlineBanking().processCustomer(3, s -> System.out.println(s +" is Happy!!"));
        }

    }
}
