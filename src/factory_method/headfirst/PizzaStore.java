package factory_method.headfirst;

abstract public class PizzaStore {
    public Pizza orderPizza(String type) {
        Pizza pizza = createPizza(type); // factory method 사용
        pizza.prepare();
        pizza.bake();
        pizza.box();
        return pizza;
    }

    abstract Pizza createPizza(String type); // factory method 사용
}
