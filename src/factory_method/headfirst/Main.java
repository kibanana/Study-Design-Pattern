package factory_method.headfirst;

public class Main {
    public static void main(String[] args) {
        ChicagoStylePizzaStore cStore = new ChicagoStylePizzaStore();
        NYStylePizzaStore nStore = new NYStylePizzaStore();

        cStore.orderPizza("cheese");
        nStore.orderPizza("cheese");
        cStore.orderPizza("pepperoni");
        nStore.orderPizza("pepperoni");
    }
}
