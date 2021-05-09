package decorator.headfirst;

public class FreshCream extends CondimentDecorator { // Concrete Decorator
    Beverage beverage;

    public FreshCream(Beverage beverage) {
        description = "생크림";
        this.beverage = beverage;
    }

    @Override
    public double getCost() {
        return 0.05 + beverage.getCost();
    }

    @Override
    public String getDescription() {
        return description + " " + beverage.getDescription();
    }
}