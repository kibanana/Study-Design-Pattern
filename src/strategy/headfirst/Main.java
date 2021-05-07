package strategy.headfirst;

public class Main {
    public static void main(String args[]) {
        Duck myDuck = new MallardDuck();
        myDuck.performFly();
        myDuck.performQuack();

        myDuck.setFlyBehavior(new FlyRocketPowered());
        myDuck.performFly();

        System.out.println("=====");

//        Duck myMachineDuck = new MachineDuck();
//        myMachineDuck.performFly();
//        myMachineDuck.performQuack();
//
//        myMachineDuck.setQuackBehavior(new KoreanQuack());
//        myMachineDuck.performQuack();

        // lambda
        myDuck.setFlyBehavior(
            () -> System.out.println("날기에 실패했다!")
        );
        myDuck.performFly();
    }
}
