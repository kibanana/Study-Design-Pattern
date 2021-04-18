# Factory Method Pattern

[팩토리 메소드 패턴 (Factory Method Pattern)](https://johngrib.github.io/wiki/factory-method-pattern/)

> 객체를 생성하기 위한 인터페이스를 정의하고, 인스턴스 생성은 서브클래스가 결정하게 한다.

팩토리 메소드 패턴(Factory Method Pattern), 가상 생성자 패턴(Virtual Constructor Pattern)으로 불린다.

## 의도
GoF는 다음과 같이 팩토리 메소드 패턴의 의도를 밝힌다.

> 객체를 생성하기 위해 인터페이스를 정의하지만, 어떤 클래스의 인스턴스를 생성할지에 대한 결정은 서브클래스가 내리도록 합니다.

![img.png](factoryMethodPattern.png)

## 요약
- 객체 생성을 캡슐화하는 패턴이다.
- `Creator`의 서브클래스에 팩토리 메소드를 정의하여 팩토리 메소드 호출로 적절한 `ConcreteProduct` 인스턴스를 반환하게 한다.

## 구현시 고려할 점들
- 팩토리 메소드 패턴의 구현 방법은 크게 두 가지가 있다.
    - `Creator`를 추상 클래스로 정의하고, 팩토리 메소드는 `abstract`로 선언하는 방법
    - `Creator`가 구체 클래스이고, 팩토리 메소드의 기본 구현을 제공하는 방법
- 팩토리 메소드의 인자를 통해 다양한 `Product`를 생성하게 한다.
    - 팩토리 메소드에 잘못된 인자가 들어올 경우의 런타임 에러 처리에 대해 고민할 것
    - Enum 등을 사용하는 것도 고려할 필요가 있다.

## 예제
- Java 언어로 배우는 디자인 패턴 입문의 예제 (생략)
- 헤드 퍼스트 디자인 패턴의 예제 (생략)

## 인용
Allen Holub은 "실용주의 디자인 패턴"에서 이 패턴에 대해 다음과 같이 언급했다.

> Factory Method 패턴은 기반 클래스에 알려지지 않은 구체 클래스를 생성하는 Template Method라 할 수 있다. Factory Method의 반환 타입은 생성되어 반환되는 객체가 구현하고 있는 인터페이스이다. Factory Method는 또한 기반 클래스 코드에 구체 클래스의 이름을 감추는 방법이기도 하다(Factory Method는 부적절한 이름이다. 사람들은 객체를 생성하는 모든 메소드를 자연스레 팩토리 메소드라 부르는 경향이 있는데, 이러한 생성 메소드가 모두 Factory Method 패턴을 사용하는 것은 아니다).