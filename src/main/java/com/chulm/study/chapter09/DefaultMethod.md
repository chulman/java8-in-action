# Default Method

- 자바8에서는 기본 구현을 포함하는 인터페이스를 정의하는 두 가지 방법을 정의
    + 인터페이스 내부의 정적 메소드 사용
    + 인터페이스의 기본 구현을 제공하는 디폴트 메소드 사용
 
 ```java
 
 default void sort(Comparator<? super E> c){
    Collections.sort(this, c);
 }

```
- default 키워드는 디폴트 메소드임을 가르킨다.
- 결국 디폴트 메소드를 사용하면 자바 API의 호환성을 유지하며 라이브러리르  바꿀 수 있다.