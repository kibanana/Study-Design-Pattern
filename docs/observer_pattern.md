# Observer Pattern

옵저버 패턴

[[Design Pattern] 옵저버 패턴이란](https://gmlwjd9405.github.io/2018/07/08/observer-pattern.html)

- 한 객체의 상태 변화에 따라 다른 객체의 상태도 연동되도록 **일대다 객체 의존 관계**를 구성하는 패턴
    - 데이터의 변경이 발생했을 경우 **상대 클래스나 객체에 의존하지 않으면서 데이터 변경을 통보**하고자 할 때 유용함
    - ex 1) 새로운 파일을 추가하거나 기존 파일을 삭제했을 때 탐색기는 다른 탐색기에게 즉시 변경을 통보해야 함
    - ex 2) 차량 연료량 클래스는 연료량이 부족한 경우 연료량을 알아야하는 구체적인 클래스(연료량 부족 경고 클래스, 주행 가능 거리 출력 클래스)에 직접 의존하지 않는 방식으로 연료량 변화를 통보해야 함
- 행위(Behavioral) 패턴 중 하나

    ![img.png](images/observerPattern.png)
- 옵저버 패턴은 통보 대상 객체의 관리를 `Subject` 클래스와 `Observer` 인터페이스로 일반화함
    - 이를 통해 데이터 변경을 통보하는 클래스(`ConcreteSubject`)는 통보 대상 클래스나 객체(`ConcreteObserver`)에 대한 의존성을 없앨 수 있음
    - 결과적으로 통보 대상 클래스나 객체(`ConcreteObserver`)의 변경에도 **통보하는 클래스(`ConcreteSubject`)를 수정 없이 그대로 사용할 수 있음**
- 역할
    - `Observer`
        - 데이터 변경을 통보받는 인터페이스
        - `Subject`에서는 `Observer` 인터페이스의 `update` 메서드를 호출함으로써 `ConcreteSubject`의 데이터 변경을 `ConcreteObserver`에게 통보함
    - `Subject`
        - `ConcreteObserver` 객체를 관리하는 요소
        - `Observer` 인터페이스를 참조해서 `ConcreteObserver`를 관리하므로 `ConcreteObserver`의 변화에 독립적인 것이 가능함
    - `ConcreteSubject`
        - 변경 관리 대상이 되는 데이터가 있는 클래스(= 통보하는 클래스)
        - 데이터 변경을 위한 메서드 `setState`가 있으며, 이 메서드에서는 자신의 데이터인 `subjectState`를 변경하고 `Subject`의 `notifyObservers` 메서드를 호출해서 `ConcreteObserver` 객체에 변경을 통보함
    - `ConcreteObserver`
        - `ConcreteSubject`의 변경을 통보받는 클래스
        - `Observer` 인터페이스의 `update` 메서드를 구현함으로써 변경을 통보받음
        - 변경된 데이터는 `ConcreteSubject`의 `getState` 메서드를 호출함으로써 변경을 조회함

- 행위(Behavioral) 패턴
    - 객체나 클래스 사이의 알고리즘이나 책임 분배에 관련된 패턴
    - 한 객체가 혼자 수행할 수 없는 작업을 여러 객체로 어떻게 분배하는지, 또 그렇게 하면서도 객체 사이의 결합도를 최소화하는 것에 중점을 둔다.
    
## 예시 - 여러가지 방식으로 성적 출력하기

![img.png](images/observerPattern1.png)

### 문제점
1. 성적을 다른 형태로 출력하는 경우
    
    성적을 목록으로 출력하지 않고 성적의 최소/최대 값만 출력하려면?
   
    점수 변경에 대한 통보 대상 클래스가 다른 대상 클래스(DataSheetView -> MinMaxView)로 바뀌면 기존 ScoreRecord 클래스의 내용을 수정(DataSheetView 대신 MinMaxView 저장)해야 하므로 OCP에 위배된다.
2. 동시 혹은 순차적으로 성적을 출력하는 경우
    
    성적이 입력되었을 때 최대 3개 목록, 최대 5개 목록, 최소/최대 값을 동시에 출력하려면?
   
    처음에는 목록으로 출력하고 나중에는 최소/최대 값을 출력하려면?
   
    점수 변경에 대한 통보 대상 클래스가 다른 대상 클래스(DataSheetView -> MinMaxView)로 바뀌면 기존 ScoreRecord 클래스의 내용을 수정(DataSheetView와 MinMaxView 저장)해야 하므로 OCP에 위배된다.

![img.png](images/observerPattern2.png)

### 해결

문제를 해결하기 위해서는 **공통 기능을 상위 클래스 및 인터페이스로 일반화**하고 이를 활용하여 통보하는 클래스(ScoreRecord 클래스)를 구현해야 한다.

- 즉, ScoreRecord 클래스에서 변화하는 부분을 식별하고 이를 일반화시켜야 한다.
    - 이를 통해 성적 통보 대상이 변경되더라도 ScoreRecord 클래스를 그대로 재사용할 수 있다.
- ScoreRecord 클래스에서 하는 작업
    - 통보 대상인 객체를 참조하는 것을 관리(추가/제거) -> `Subject` 추상클래스로 일반화
    - 각 통보 대상인 객체의 update 메서드 호출(addScore 메서드) -> `Observer` 인터페이스로 일반화
    
![img.png](images/observerPattern3.png)

![img.png](images/observerPattern4.png)

- `Observer`
  - 추상화된 통보 대상
- `DataSheetView`, `MinMaxView`
  - `Observer`를 `implements` 함으로써 구체적인 통보대상이 됨
- `Subject`
  - 성적 변경에 관심이 있는 대상 객체들을 관리
- `ScoreRecord`
  - `Subject`를 `extends` 함으로써 구체적인 통보 대상을 직접 참조하지 않아도 됨