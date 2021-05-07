package strategy.headfirst;

public class MachineDuck extends Duck {
    public MachineDuck() {
        quackBehavior = new Quack();
        flyBehavior = new FlyRocketPowered();
    }
}