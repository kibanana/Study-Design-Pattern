package observer.headfirst;

public interface Observer {
    // update 메소드의 인자로 Subject가 아니라 각 값을 전달한다는 점이 GoF 예제와 다르다.
    // 더욱 느슨한 결합을 선호하고, 전달해야 할 값이 몇 개 없다면 이 방법이 좋을 것이다.

    public void update(float temp, float humidity, float pressure);
}
