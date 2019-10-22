package com.chulm.study.chapter10;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.Properties;

public class Optional06 {
    public static void main(String[] args) {
        // 기본형 특화 Optional을 사용할 수 있다.
        OptionalInt optionalInt = OptionalInt.empty();

        // 응용 문제

        Properties properties = new Properties();
        properties.setProperty("a", "5");
        properties.setProperty("b", "-2");
        properties.setProperty("c", "true");

        System.err.println(readDuration(properties, "a"));
        System.err.println(readDuration(properties, "b"));
        System.err.println(readDuration(properties, "c"));

    }

    public static int readDuration(Properties properties, String name) {
        return Optional.ofNullable(properties.getProperty(name))
                       .flatMap(Optional06::stringToIntegerOptional).filter(integer -> integer>1).orElse(0);
    }

    public static Optional<Integer> stringToIntegerOptional(String s){
        try{
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e){
            return Optional.empty();
        }
    }


//    public int readDuration(Properties properties, String name) {
//        String value = properties.getProperty(name);
//
//        if (value != null) {
//            try {
//                int i = Integer.parseInt(value);
//                if (i > 0) {
//                    return i;
//                }
//            } catch (NumberFormatException e) {
//            }
//        }
//        return 0;
//    }
}
