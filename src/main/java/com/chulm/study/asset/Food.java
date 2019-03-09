package com.chulm.study.asset;

public class Food {
    int calories;
    String name;

    public Food(int calories, String name) {
        this.calories = calories;
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean foodIsRice(){
        return getName().equalsIgnoreCase("rice");
    }

    @Override
    public String toString() {
        return "Food{" +
                "calories=" + calories +
                ", name='" + name + '\'' +
                '}';
    }
}
