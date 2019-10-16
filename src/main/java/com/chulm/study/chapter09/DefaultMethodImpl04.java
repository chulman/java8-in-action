package com.chulm.study.chapter09;

interface G{
    default  void hello(){
        System.err.println("hello from g");
    }
}
interface H extends G{

}
interface I extends G{

}

public class DefaultMethodImpl04 implements H, I{

    public static void main(String[] args){
        //g 출력
        //h나 i 인터페이스의 default hello를 구현하면 2규칙으로 서브 인터페이스의 메소드가 출력된다.
        // 둘다 추가할 경우 컴파일 에러
        new DefaultMethodImpl04().hello();
    }
}
