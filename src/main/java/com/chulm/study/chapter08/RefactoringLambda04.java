package com.chulm.study.chapter08;

/**
 * 객체 지향 디자인 패턴을 활용한 리팩토링 - strategy
 */

public class RefactoringLambda04 {

    // Functional Interface
    interface ValidationStrategy {
        boolean execute(String s);
    }

    static class IsAllLowerCase implements ValidationStrategy{
        @Override
        public boolean execute(String s) {
            return s.matches("[a-z]+");
        }
    }

    static class IsNumeric implements ValidationStrategy {
        @Override
        public boolean execute(String s) {
            return s.matches("\\d+");
        }
    }

     static class Validator {
        private final ValidationStrategy strategy;

        public Validator(ValidationStrategy strategy) {
            this.strategy = strategy;
        }

        public boolean validate(String s){
            return strategy.execute(s);
        }
    }

    public static void main(String[] args){

        Validator lowerValidator = new Validator(new IsAllLowerCase());
        boolean b1  = lowerValidator.validate("ssss");
        System.out.println(b1);

        Validator numericValidator = new Validator(new IsNumeric());
        boolean b2  = numericValidator.validate("sAsA");
        System.out.println(b2);

        // 람다 활용
        Validator lowerValidatorWithLambda = new Validator(s -> s.matches("[a-z]+"));
        lowerValidatorWithLambda.validate("sss");
    }
}
