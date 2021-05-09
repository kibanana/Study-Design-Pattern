# Adapter Pattern

[어댑터 패턴 (Adapter Pattern)](https://johngrib.github.io/wiki/adapter-pattern/)

[[Design Pattern] 어댑터 패턴 (Adapter Pattern)](https://brownbears.tistory.com/493?category=378797)

[디자인패턴 - 어댑터 패턴(Adapter Pattern)](https://coding-start.tistory.com/256?category=808950)

[어댑터 패턴(Adapter Pattern)](https://www.crocus.co.kr/1540?category=337544)

[[Design Pattern] Adapter Pattern](https://beomseok95.tistory.com/253?category=1066005)

어댑터 패턴은 적응자 패턴, 래퍼(Wrapper) 패턴이라고도 불린다.

## 의도

> 클래스의 인터페이스를 사용자가 기대하는 인터페이스 형태로 적응(변환) 시킵니다. 서로 일치하지 않는 인터페이스를 갖는 클래스들을 함께 동작시킵니다. - GoF 책

> 한 클래스의 인터페이스를 클라이언트에서 사용하고자 하는 다른 인터페이스로 변환합니다. 어댑터를 이용하면 인터페이스 호환성 문제 때문에 같이 쓸 수 없는 클래스들을 연결해서 쓸 수 있습니다. - 헤드 퍼스트 디자인 패턴

## 예제 - 오리(헤드 퍼스트 디자인 패턴)

(생략)

---

한 클래스의 인터페이스를 다른 클래스에서 사용하고자 할 때, 다른 클래스에서 사용할 수 있도록 호환성을 제공해주는 패턴입니다. 예를 들어, 한국에서는 `220v`가 표준이지만 일본은 `110v`가 표준입니다. 한국에서 사용하는 충전기를 일본에 가져가면 호환이 되지 않아서 충전이 불가능합니다. 이 때, 돼지코와 같은 변환기(어댑터)를 사용해 한국에서 가져온 충전기를 일본에서 충전할 수 있도록 하는 기능이 여기서 말하는 어댑터 패턴이라 볼 수 있습니다.

## 예제 - 전자제품

(생략)

---

