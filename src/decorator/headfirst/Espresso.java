package decorator.headfirst;

public class Espresso extends Beverage {
    public Espresso() {
        description = "에스프레소";
    }

    @Override
    public double getCost() {
        return 1.99;
    }
}
