package builder.effective.pizza;

public class PizzaBuilder {
    private String bread;
    private String cheese;
    private Number pepperoni;
    private Number meat;
    private Number olive;
    private Number paprika;

    public PizzaBuilder(String bread, String cheese) {
        this.bread = bread;
        this.cheese = cheese;
    }

    public PizzaBuilder addPepperoni(Number pepperoni) {
        this.pepperoni = pepperoni;
        return this;
    }

    public PizzaBuilder addMeat(Number meat) {
        this.meat = meat;
        return this;
    }

    public PizzaBuilder addOlive(Number olive) {
        this.olive = olive;
        return this;
    }

    public PizzaBuilder addPaprika(Number paprika) {
        this.paprika = paprika;
        return this;
    }

    public Pizza build() {
        return new Pizza(this.bread, this.cheese, this.pepperoni, this.meat, this.olive, this.paprika);
    }
}
