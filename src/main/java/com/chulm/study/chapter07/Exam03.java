package com.chulm.study.chapter07;

// 커스텀 Spliterator 구현
public class Exam03 {

    public int CountWordsIteratively(String s) {
        int count = 0;
        boolean lastSpace = true;

        for (char c : s.toCharArray()) {
            if (Character.isWhitespace(c)) {
                lastSpace = true;
            } else {
                if (lastSpace) {
                    count++;
                }
                lastSpace = false;
            }
        }
        return count;
    }

    public static void main(String[] args){
        String s = "1234 Check Your White Space Na";
        System.err.println("Found:" + new Exam03().CountWordsIteratively(s) + "Words");
    }
}
