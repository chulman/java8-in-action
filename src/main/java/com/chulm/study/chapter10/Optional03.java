package com.chulm.study.chapter10;

import java.util.*;

import static java.util.stream.Collectors.toSet;

public class Optional03 {

    public static void main(String[] args){
        Person person = new Person();
        Car car = new Car();
        Insurance insurance = new Insurance();
        insurance.name = "name";

        Optional<Person> optionalPerson = Optional.of(person);

        Optional<Car> optionalCar = Optional.of(car);
        person.setCar(optionalCar);
        Optional<Insurance> insurance1 = Optional.of(insurance);
        car.setInsurance(insurance1);


        //Optional<Optional<Car>>를 반환하므로, getInsurance 메소드를 지원하지 않는다.
//        Optional<String> name = optionalPerson.map(Person::getCar)
//                                              .map(Car::getInsurance)
//                                              .map(Insurance::getName);


        System.err.println(getCarInsuranceName(optionalPerson));




    }

    //flatmap은 함수를 인수로 받아서 다른 스트림으로 반환한다.
    //중첩 optional을 방지하고 평준화한다.
    // 평준화 과정은 이론적으로 두 optional을  합치는  기능을 수행하면서, 둘 중 하나라도 null이면 빈 optional을 반환한다.
    public static String getCarInsuranceName(Optional<Person> person) {
        return person.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }



}
