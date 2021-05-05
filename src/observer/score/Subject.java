package observer.score;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject { // 데이터에 공통적으로 들어가는 메서드 -> 일반화
    private List<Observer> observers = new ArrayList<Observer>(); // 추상화된 통보 대상 목록

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update();
        }
    }
}
