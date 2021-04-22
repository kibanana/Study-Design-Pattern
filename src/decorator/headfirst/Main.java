package decorator.headfirst;

public class Main {
    public static void main(String[] args) {
        Beverage a = new Espresso();
        a = new FreshCream(a);

        Beverage b = new HouseBlend();
        b = new FreshCream(b);

        Beverage c = new HouseBlend();
        c = new Mocha(c);
        c = new Mocha(c);

        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());
    }
}
