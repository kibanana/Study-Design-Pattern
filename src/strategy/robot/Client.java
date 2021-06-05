package strategy.robot;

public class Client {
    public static void main(String args[]) {
        // 스트래티지 패턴을 이용하면 새로운 기능의 추가(새로운 이동, 공격 기능)가 기존의 코드에 영향을 미치지 못하게 하므로 OCP를 만족 하는 설계가 된다.
        Robot t = new TaekwonV("태권브이");
        Robot a = new Atom("아톰");
        Robot s = new Sungard("선가드");

        t.setAttackStrategy(new PunchStrategy()); // 공격
        t.setMovingStrategy(new WalkingStrategy()); // 이동

        a.setAttackStrategy(new MissileStrategy());
        a.setMovingStrategy(new FlyingStrategy());

        s.setAttackStrategy(new PunchStrategy());
        s.setMovingStrategy(new FlyingStrategy());


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
