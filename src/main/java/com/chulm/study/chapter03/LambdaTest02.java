package com.chulm.study.chapter03;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;

@FunctionalInterface
interface BufferedReaderProcess {
    String process(BufferedReader br) throws IOException;
}

public class LambdaTest02 {

    public static void main(String[] args) {


        try {
            String oneLine = process((BufferedReader br) -> br.readLine());
            String twoLine = process((BufferedReader br) -> br.readLine() + br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String process(BufferedReaderProcess p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br);
        }
    }
}