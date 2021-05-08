package strategy.robot;

public class Client {
    public static void main(String args[]) {
        Robot t = new TaekwonV("태권브이");
        Robot a = new TaekwonV("아톰");
        Robot s = new TaekwonV("선가드");

        System.out.println("My name is " + t.getName());
        t.move();
        t.attack();

        System.out.println("=====");

        System.out.println("My name is " + a.getName());
        a.move();
        a.attack();

        System.out.println("=====");

        System.out.println("My name is " + s.getName());
        s.move();
        s.attack();
    }
}
