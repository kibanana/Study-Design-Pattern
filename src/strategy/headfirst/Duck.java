package strategy.headfirst;

public class Duck {
    // 참고로 IntelliJ IDEA에도 전략 패턴의 메소드 명명법이 등록되어 있는지
    // ~Behavior로 끝나는 인터페이스를 멤버로 선언한다면 New Deligate Method메뉴로 새로운 메소드를 만들 때
    // 자동으로 perform~으로 시작하는 이름을 붙여 준다.
    QuackBehavior quackBehavior;    // interface - 소리를 내는 행동
    FlyBehavior flyBehavior;        // interface - 나는 행동

    public void performQuack() {
        quackBehavior.quack();
    }

    public void performFly() {
        flyBehavior.fly();
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }
}