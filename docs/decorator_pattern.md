# Decorator Pattern

[데코레이터 패턴(Decorator Pattern)](https://jdm.kr/blog/78)

1. 정의
    
   객체를 확장할 때 서브 클래스를 이용해 동적(dynamic)으로 확장한다.

2. 예제
   
   (생략)

3. 정리
    
    `ArrayList` 등으로 중복된 맛을 하나로 뭉쳐서 처리할 수 있다면 더 좋았겠지만 일단 간단하게 나열만 했다.
   
    이러한 데코레이터 패턴이 많이 보이는 자바 API는 파일 I/O 관련 부분이다. 자바에서 파일을 읽어들일 때 보통 다음처럼 사용한다.
   
    ```java
    // Example - Read a file
    BufferedReader br = new BufferedReader(new FileReader(new File("test.txt")));
    ```
   
    보다시피 데코레이터 패턴을 사용해서 유연하게 기능 확장을 할 수 있지만, 대신 각각의 데코레이터 클래스들이 어떤 기능을 수행하는지 알고 있어야 하고 자잘한 클래스들이 많이 생기는 것이 단점이므로 적절하게 활용해야 한다.