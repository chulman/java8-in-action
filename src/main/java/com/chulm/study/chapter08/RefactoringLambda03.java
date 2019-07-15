package com.chulm.study.chapter08;

import com.chulm.study.asset.Food;

import java.util.*;
import java.util.stream.Collectors;

public class RefactoringLambda03 {

    enum CaloricLevel {
        DIET, NORMAL, FAT;
    }
    public static void main(String[] args){

        List<Food> foodList = new ArrayList<>();
        foodList.add(new Food(300, "orange"));
        foodList.add(new Food(200, "apple"));


        // lambda
//        Map<CaloricLevel,List<Food>> foodByName = foodList.stream().collect(Collectors.groupingBy(o -> {
//            Food food = (Food)o;
//            if(food.getCalories()>500) return CaloricLevel.FAT;
//            else if(food.getCalories()<300 && food.getCalories()<=500) return CaloricLevel.NORMAL;
//            else return CaloricLevel.DIET;
//        }));

        //method reference
        Map<CaloricLevel,List<Food>> foodByName = foodList.stream().collect(Collectors.groupingBy(RefactoringLambda03::calculateLevel));


    }

    public static CaloricLevel calculateLevel(Food food){
        if(food.getCalories()>500) return CaloricLevel.FAT;
        else if(food.getCalories()<300 && food.getCalories()<=500) return CaloricLevel.NORMAL;
        else return CaloricLevel.DIET;
    }
}
