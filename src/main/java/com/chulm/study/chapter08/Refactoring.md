## refactoring

### 객체 지향 패턴 간소화

- strategy
- template method
- observer
- chain of responsibility
- factory


### 코드 가독성과 유연성을 개선

> this

- 람다에서 this는 람다를 감싸는 클래스를 가르킨다.
- 익명 클래스는 감싸고 있는 클래스의 변수(shadow variable)를 가릴 수 있다.
  + 람다는 가릴 수 없다.


- 익명 클래스를 람다 표현식으로 바꾸면 콘텍스트 오버로딩에 따른 모호함이 초래될 수 있다.

> super
- super 또한 람다에선 다른 의미를 갖는다.



> method reference

- 람다는 장황하고 복잡하다.
- 메소드 레퍼런스는 코드의 의도를 알리고 가독성을 높이는 좋은 방법이다.


- comparing, sum, maximum, summingInt 등 람다로 reducing 연산을 하지 말고 Collectors API를 사용하면 코드의 의도가 더 명확하다. 
```java
// inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));    
   inventory.sort(comparing(Apple::getWeight)); // 코드 자체로 설명된다.
```


### 함수형 인터페이스 적용

- 조건부 연기 실행(conditional deferred execution) 및 실행 어라운드(execute around) 패턴을 통한 람다 리팩토링


> 조건부 연기 실행
- 특정 조건에서만 실행되도록 연기한다. 

> 실행 어라운드
- 반복적으로 실행, 준비, 종료되는 로직을 추상화한다.

 