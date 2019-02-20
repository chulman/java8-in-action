package com.chulm.study.chapter01;

import javax.swing.*;
import java.io.File;
import java.io.FileFilter;

public class MethodReference {

    public void base(){

        /**
         *  클레스를 통해 메소드를 전달 - 자바세계에서 2급 시민이다.
         */
        File[] hiddneFiles = new File(".").listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return false;
            }
        });
    }


    /**
     *  함수를 메소드를 전달 - 자바세계에서 List, Map 과 같은 1급 시민으로 변화했다.
     */
    public void change(){

        File[] hiddneFiles = new File(".").listFiles(File::isHidden);
    }
}
