package adapter.duck;

public class Client {
    public static void main(String args[]) {
        MallardDuck d = new MallardDuck();
        WildTurkey t = new WildTurkey();
        Duck dButT = new TurkeyAdapter(new WildTurkey());

        d.quack();
        t.gobble();
        dButT.quack();

        d.fly();
        t.fly();
        dButT.fly();
    }
}
