package strategy.robot;

public class Sungard extends Robot {
    public Sungard(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println("미사일");
    }

    @Override
    public void move() {
        System.out.println("only 걷기");
    }
}
