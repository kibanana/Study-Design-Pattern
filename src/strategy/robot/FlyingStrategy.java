package strategy.robot;

public class FlyingStrategy implements MovingStrategy {
    @Override
    public void move() {
        System.out.println("날기");
    }
}
