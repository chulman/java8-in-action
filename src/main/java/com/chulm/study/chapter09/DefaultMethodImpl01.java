package com.chulm.study.chapter09;

public class DefaultMethodImpl01 {
    public static void main(String[] args){
        Monster m = new Monster();
        //default method는 자동으로 제공된다.
        m.rotataBy(100);
        m.setRelativeSize(200,200);
    }


}

class Monster implements Resizable, Rotatable, Sized {
    @Override
    public int getWidth() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public void setWidth(int width) {

    }

    @Override
    public void setHeight(int height) {

    }

    @Override
    public void setAbsoluteSize(int width, int height) {

    }

    @Override
    public void setRotationAngle(int angleInDegrees) {

    }

    @Override
    public int getRotationAngle() {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }
}


