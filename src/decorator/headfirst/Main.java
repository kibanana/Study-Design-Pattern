package decorator.headfirst;

public class Main {
    public static void main(String[] args) {
        Beverage a = new Espresso(); // 에스프레소
        a = new FreshCream(a); // 생크림 + 에스프레소

        Beverage b = new HouseBlend(); // 하우스 블렌드 커피
        b = new FreshCream(b); // 생크림 + 하우스 블렌드 커피

        Beverage c = new HouseBlend();
        c = new Mocha(c);
        c = new Mocha(c);

        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());
    }
}
