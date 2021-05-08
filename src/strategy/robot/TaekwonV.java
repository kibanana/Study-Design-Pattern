package strategy.robot;

public class TaekwonV extends Robot {
    public TaekwonV(String name) {
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
