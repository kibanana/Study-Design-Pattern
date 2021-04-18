package factory_method.java;

public class Main {
    public static void main(String[] args) {
        Factory creditCardFactory = new CreditCardFactory();
        Factory pointCardFactory = new PointCardFactory();

        Product c1 = creditCardFactory.create("김");
        Product c2 = creditCardFactory.create("최");
        Product c3 = creditCardFactory.create("박");

        Product p1 = pointCardFactory.create("가");
        Product p2 = pointCardFactory.create("나");
        Product p3 = pointCardFactory.create("다");

        System.out.println("=====");

        System.out.println("신용카드 사용자: " + String.join(",", ((CreditCardFactory) creditCardFactory).getOwners()));
        System.out.println("포인트카드 사용자: " + String.join(",", ((PointCardFactory) pointCardFactory).getOwners()));

        System.out.println("=====");

        System.out.println("=====");

        c1.use();
        c2.use();
        c3.use();

        System.out.println("=====");

        p1.use();
        p2.use();
        p3.use();
    }
}
