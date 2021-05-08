package strategy.robot;

public class Atom extends Robot {
    public Atom(String name) {
        super(name);
    }

    @Override
    public void attack() {
        System.out.println("미사일");
    }

    @Override
    public void move() {
        System.out.println("only 날기");
    }
}
