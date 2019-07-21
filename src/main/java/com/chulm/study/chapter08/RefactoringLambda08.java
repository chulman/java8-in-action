package com.chulm.study.chapter08;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * 객체 지향 디자인 패턴을 활용한 리팩토링 - factory
 */
public class RefactoringLambda08 {

    static abstract class Product {
        String price;
    }

    static class Loan extends Product {}

    static class Stock extends Product {}

    static class ProductFactory {
        public static Product createProduct(String name){
            switch (name) {
                case "loan":
                    return new Loan();
                case "stock":
                    return new Stock();
            }
            return null;
        }

        // 함수형 인터페이스로 구현
        final static Map<String, Supplier<Product>> map = new HashMap<>();

        static {
            map.put("loan", Loan::new);
            map.put("stock", Stock::new);
        }

        public static Product createProductWithLambda(String name){
            return map.get(name).get();
        }
    }

    public static void main(String[] args){
        Product loan = ProductFactory.createProduct("loan");

        // 람다를 통한 사용
        ProductFactory.createProductWithLambda("loan");


    }



}
