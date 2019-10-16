package com.chulm.study.chapter09;

//기능이 중복되지 않은 최소한의 인터페이스
public interface Rotatable {

    void setRotationAngle(int angleInDegrees);
    int getRotationAngle();

    default void rotataBy(int angleInDegrees){
        setRotationAngle((getRotationAngle() + angleInDegrees)%360);
    }
}
