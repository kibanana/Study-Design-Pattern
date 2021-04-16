package builder.effective.pizza;

public class Main {
    public static void main(String[] args) {
        PizzaBuilder builder = new PizzaBuilder("crust", "mozzarella");
        Pizza pizzaOrderedByYewon = builder
                    .addPaprika(1)
                    .addMeat(2)
                    .addPepperoni(3)
                    .build();
        System.out.println(pizzaOrderedByYewon);
    }
}
