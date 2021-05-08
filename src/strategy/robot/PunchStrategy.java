package strategy.robot;

public class PunchStrategy implements AttackStrategy {
    @Override
    public void attack() {
        System.out.println("주먹");
    }
}
