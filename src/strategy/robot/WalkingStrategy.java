package strategy.robot;

public class WalkingStrategy implements MovingStrategy {
    @Override
    public void move() {
        System.out.println("걷기");
    }
}
