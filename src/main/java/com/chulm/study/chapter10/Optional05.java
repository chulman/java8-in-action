package com.chulm.study.chapter10;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Optional05 {

    public static void main(String[] args){
        Map<String, Object> map = new HashMap<>();

        //null
        map.get("key");

        // 잠재적으로 null을 발생시킬 수 있는 대상을 Optinal로 감싸기

        Optional<Object> optional = Optional.ofNullable(map.get("key"));


    }
}
