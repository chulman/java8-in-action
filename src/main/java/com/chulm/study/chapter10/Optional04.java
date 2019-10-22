package com.chulm.study.chapter10;

import java.util.Optional;

public class Optional04 {

    //null safe method
    // 명시적이다. 개선이 필요함
    public Optional<Insurance> nullSafeFindCheapestInsurance(Optional<Person> person, Optional<Car> car){
        if(person.isPresent() && car.isPresent()){
            return Optional.of(findCheapestInsurance(person.get(), car.get()));
        } else{
            return Optional.empty();
        }
    }

    //개선된 버전
    public Optional<Insurance> nullSafeFindCheapestInsurance2(Optional<Person> person, Optional<Car> car){
        return person.flatMap(person1 -> car.map(car1 -> findCheapestInsurance(person1, car1)));
    }

    public Insurance findCheapestInsurance(Person person, Car car){
        return new Insurance();
    }
}
