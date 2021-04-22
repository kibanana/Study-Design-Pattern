package decorator.headfirst;

public class Mocha extends CondimentDecorator {
    Beverage beverage;

    public Mocha(Beverage beverage) {
        description = "모카";
        this.beverage = beverage;
    }

    @Override
    public double getCost() {
        return 0.20 + beverage.getCost();
    }

    @Override
    public String getDescription() {
        return description + " " + beverage.getDescription();
    }
}
