# NPE

- 일반적으로 명령형 프로그래밍 시 NPE을 피하는 방법

### 깊은 의심

```java
pubclic String getInsurance(Person person){
    if(person != null){
        Insurance insurance = person.getInsurance();
        if(insurance != null){
            ....
        }
    }
}
```

- 위와 같은 반복 패턴(recurring pattern) 코드를 깊은 의심(deep doubt)라고 부른다.


# null 때문에 발생하는 문제

- 에러의 근원이다.
    + NPE는 자바에서 가장 흔한 에러이다.
    
- 코드를 어지럽힌다.
    + null로 인해 가독성이 떨어진다.
    
- 아무 의미가 없다.

- 자바 철학에 위배된다.
    + 자바는 개발자로부터 모든 포인터를 숨겼지만 null은 예외다.
    
- 형식 시스템에 구멍을 만든다.
    + null은 무형식이고 정보를 담지 않으므로, 모든 레퍼런스 형식에 null을 할당할 수 있다.
    + 이런식으로 Null이 퍼지면 어떤 의미로 사용되었는지 알 수 없다.


# Optional 

- 자바8은 하스켈과 스칼라의 영향을 받아 java.util.Optional이라는 새로운 클래스를 제공한다.
- null이 할당될 자리에 Optional 클래스가 할당 되며, empty() 메소드로 optional이 반환한다.
- optional.empty는 Optional의 singleton을 반환하는 정적 팩토리 메소드이다.


```java
public class Car {
    private Optional<Insurance> car;  //차를 소유하지 않았을 경우 Optional로 정의한다.
    public Optional<Insurance> getCar() {return car;};
}

public class Insurance {
    private String name;        // 만약 name 값이 반드시 있어야 한다면,
                                // 모든 값을 optional 처리하는 것은 바람직하지 않다.
                                // optinal 선택형 값을 캡슐화하는 클래스이다.
    public String getName(){return name;}
}
```    