package adapter.duck;

public class TurkeyAdapter implements Duck {
    Turkey turkey;

    public TurkeyAdapter(Turkey turkey) {
        this.turkey = turkey;
    }

    @Override
    public void quack() {
        turkey.gobble();
    }

    @Override
    public void fly() {
        for (int i = 0; i < 5; i++) { // 오리처럼 긴 거리를 날기 위해 다섯 번 날아야 한다.
            turkey.fly();
        }
    }
}
