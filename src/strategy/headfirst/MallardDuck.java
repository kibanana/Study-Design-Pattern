package strategy.headfirst;

public class MallardDuck extends Duck {
    public MallardDuck() {
        quackBehavior = new KoreanQuack();
        flyBehavior = new FlyWithWings();
    }
}