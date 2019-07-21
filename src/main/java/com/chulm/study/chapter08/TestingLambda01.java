package com.chulm.study.chapter08;

import java.util.Comparator;

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void MoveRightBy(int x){
         this.x = this.x + x;
    }

    // 보이는 람다표현식의 동작 테스팅
    public final static Comparator<Point> compareByX = Comparator.comparing(Point::getX);
}

public class TestingLambda01 {


    public void test01(){
        Point p1 = new Point(5,5);
        p1.MoveRightBy(3);

        System.out.println(8==p1.x); //true
        System.out.println(5==p1.y); //true
    }

    public static void test02(){
        Point p1 = new Point(5,5);
        p1.MoveRightBy(3);

        int result = Point.compareByX.compare(p1, new Point(6,5));
        // -1 , 0 , 1
        System.out.println(result);

    }

}
